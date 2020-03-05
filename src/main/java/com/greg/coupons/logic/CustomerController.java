package com.greg.coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.dao.ICustomersDao;
import com.greg.coupons.entities.Customer;
import com.greg.coupons.entities.CustomerRegisterDetails;
import com.greg.coupons.entities.User;
import com.greg.coupons.enums.ErrorTypes;
import com.greg.coupons.enums.UserType;

@Controller
public class CustomerController {
	//------------class variables-----------------------------------------------------------------------------------------
	@Autowired
	private ICustomersDao customersDao;

	//-------------constructor----------------------------------------------------------------------------------------
	public CustomerController() {

	}
	//-----------------------------------------------------------------------------------------------------
	public void createCustomer(CustomerRegisterDetails customerRegisterDetails) throws ApplicationException{
		
		User user = new User();
		user.setPassword(customerRegisterDetails.getUserRegisterDetails().getPassword());
		user.setUserName(customerRegisterDetails.getUserRegisterDetails().getUserName());
		user.setUserPhone(customerRegisterDetails.getPhone());
		user.setUserType(UserType.CUSTOMER);
		
		Customer customer = new Customer();
		customer.setUser(user);
		customer.setAmountOfKids(customerRegisterDetails.getAmountOfKids());
		customer.setIsMarried(customerRegisterDetails.getIsMarried());
		customer.setCustomerFirstName(customerRegisterDetails.getCustomerFirstName());
		customer.setCustomerLastName(customerRegisterDetails.getCustomerLastName());
		
		
		
		
		if (customer.getAmountOfKids() < 0) {
			throw new ApplicationException(ErrorTypes.CUSTOMER_FAILED_TO_CREATE, "can't have less than 0 kids");
		}
		try {
			customersDao.save(customer);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.CUSTOMER_FAILED_TO_CREATE, "Failed to create new customer");


		}

	}
	//-----------------------------------------------------------------------------------------------------
	public void updateCustomer(Customer customer) throws ApplicationException{
		if (this.customersDao.existsByCustomerId(customer.getCustomerId()) == false) {
			throw new ApplicationException(ErrorTypes.CUSTOMER_FAILED_TO_UPDATE, "cant update customer because customer doenst exists");
		}
		customer.getUser().setCompanyId(null);
		try {
			customersDao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.CUSTOMER_FAILED_TO_UPDATE, "Failed to update  customer");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteCustomer(Long id) throws ApplicationException {
		if (this.customersDao.existsByCustomerId(id) == false) {
			throw new ApplicationException(ErrorTypes.CUSTOMER_FAILED_TO_DELETE, "cant delete customer because customer doenst exists");
		}
		try {
			this.customersDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.CUSTOMER_FAILED_TO_DELETE, "Failed to delete  customer");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public Customer getCustomer(Long id) throws ApplicationException{
		try {
			return this.customersDao.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.CUSTOMER_FAILED_TO_GET, "Failed to get  customer");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public List<Customer> getAllCustomers(Customer customer) throws ApplicationException {
		try {
			return (List<Customer>) this.customersDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.CUSTOMER_FAILED_TO_GET_ALL, "Failed to get all  customer");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	
}
