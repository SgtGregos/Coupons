package com.greg.coupons.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greg.coupons.data.internals.UserLoginData;
import com.greg.coupons.entities.Customer;
import com.greg.coupons.entities.CustomerRegisterDetails;
import com.greg.coupons.logic.CustomerController;

@RestController
@RequestMapping("/customers")
public class CustomersApi {
	//-----------------------------------------------------------------------------------------------------
	@Autowired
	private CustomerController customersController;
	//-----------------------------------------------------------------------------------------------------
	@PostMapping
	public void createCustomer(@RequestBody CustomerRegisterDetails customerRegisterDetails) throws Exception{
		System.out.println("yesss" + customerRegisterDetails);
		this.customersController.createCustomer(customerRegisterDetails);
	}
	//-----------------------------------------------------------------------------------------------------
//  URL : http://localhost:8080/customers
	@PutMapping
	public void updateCustomer(@RequestBody Customer customer) throws Exception {
		System.out.println("yesss" + customer);
		this.customersController.updateCustomer(customer);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/customers/12
	@GetMapping("/customersDetails")
	public Customer getCustomer(HttpServletRequest request) throws Exception {
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long customerId = userLoginData.getId();
		return this.customersController.getCustomer(customerId);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/customers/12
//	@DeleteMapping("{customerId}")
//	public void deleteCustomer(@PathVariable("customerId") long id) throws Exception {
//		this.customersController.deleteCustomer(id);
//	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping
	public List<Customer> getAllCustomers(Customer customer) throws Exception{
		
		return this.customersController.getAllCustomers(customer);
		
	}
	//-----------------------------------------------------------------------------------------------------
	@DeleteMapping("/deleteAccount")
	public void deleteCustomer(HttpServletRequest request) throws Exception {
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long customerId = userLoginData.getId();
		this.customersController.deleteCustomer(customerId);
	}
	//-----------------------------------------------------------------------------------------------------

}
