package com.greg.coupons.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.dao.ICompaniesDao;
import com.greg.coupons.dao.IUsersDao;
import com.greg.coupons.entities.Company;
import com.greg.coupons.entities.CompanyUserRegisterDetails;
import com.greg.coupons.entities.User;
import com.greg.coupons.enums.CompanyAndCouponType;
import com.greg.coupons.enums.ErrorTypes;
import com.greg.coupons.enums.UserType;

@Controller
public class CompaniesController {
	//------------class variables-----------------------------------------------------------------------------------------

	@Autowired
	private UsersController usersController;

	@Autowired
	private ICompaniesDao companiesDao;
	
	@Autowired
	private IUsersDao userDao;

	//-------------constructor----------------------------------------------------------------------------------------
	public CompaniesController() {

	}
	//-----------------------------------------------------------------------------------------------------
	public void createCompany(Company company) throws ApplicationException{
		if (this.companiesDao.existsByCompanyName(company.getCompanyName()) == true) {
			throw new ApplicationException( ErrorTypes.COMPANY_FAILED_TO_UPDATE, "company already exists");
		}
		
		
		try {
			this.companiesDao.save(company);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_CREATE, "Failed to create new company");
		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void updateCompany(Company company) throws ApplicationException{
		if (this.companiesDao.existsByCompanyId(company.getCompanyId()) == false) {
			throw new ApplicationException( ErrorTypes.COMPANY_FAILED_TO_UPDATE, "company doesn't exists");
		}
		try {
			this.companiesDao.save(company);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_UPDATE, "Failed to update  company");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteCompany(Long id) throws ApplicationException{
		if (this.companiesDao.existsByCompanyId(id) == false) {
			throw new ApplicationException( ErrorTypes.COMPANY_FAILED_TO_DELETE, "company doesn't exists");
		}
		try {
			this.companiesDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_DELETE, "Failed to delete  company");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public Company getCompany(Long userId) throws ApplicationException{
		
		User user = this.userDao.findById(userId).get();
		
		long companyId = user.getCompany().getCompanyId();
		
		try {
			return this.companiesDao.findById(companyId).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET, "Failed to get  company");

		}

	}
	//-----------------------------------------------------------------------------------------------------
	public List<Company> getAllCompanies(Company company) throws ApplicationException {

		try {
			return (List<Company>) this.companiesDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET_ALL, "Failed to get all  company");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public List<String> getAllCompanyTypes() throws ApplicationException {
		
		List<String> companyTypeEnumNamesList = Stream.of(CompanyAndCouponType.values()).map(CompanyAndCouponType::name).collect(Collectors.toList());
		try {
			return companyTypeEnumNamesList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET_ALL, "Failed to get all  company");
			
		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void createCompanyUser(CompanyUserRegisterDetails companyUserRegisterDetails) throws ApplicationException {
		
		Company company = this.companiesDao.findById(companyUserRegisterDetails.getCompanyId()).get();
		
		User user = new User();
		user.setUserType(UserType.COMPANY);
		user.setCompany(company);
		user.setUserPhone(companyUserRegisterDetails.getUserPhone());
		user.setPassword(companyUserRegisterDetails.getUserRegisterDetails().getPassword());
		user.setUserName(companyUserRegisterDetails.getUserRegisterDetails().getUserName());
		if(companyUserRegisterDetails.geteMail() == null) {
			user.seteMail("");
		}else {
			user.seteMail(companyUserRegisterDetails.geteMail());
		}
		
		try {
			this.userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_CREATE, "Failed to create new company");
		}
	}
	//-----------------------------------------------------------------------------------------------------
	public List<String> getAllCompaniesNames() throws ApplicationException {
		List<Company> companyList =	 (List<Company>) this.companiesDao.findAll();

		List<String> userIdAndType = new ArrayList<String>();
		for (Company temp : companyList) {
				userIdAndType.add(temp.getCompanyName());
				

		}
		try {
			return userIdAndType;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET_ALL, "Failed to get all  company");

		}
		
		
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteSelectedCompany(String companyName) throws ApplicationException {
		
		Company company = this.companiesDao.getCompanyIdByCompanyName(companyName);
		long companyId = company.getCompanyId();

		try {
			this.companiesDao.deleteById(companyId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_DELETE, "Failed to delete  user");

		}		
	}

}
