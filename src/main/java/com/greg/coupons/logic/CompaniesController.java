package com.greg.coupons.logic;

import java.sql.SQLException;
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
	public Company getCompany(Long id) throws ApplicationException{
		try {
			return this.companiesDao.findById(id).get();
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
		
		User user = new User();
		user.setUserType(UserType.COMPANY);
		user.setCompanyId(companyUserRegisterDetails.getCompanyId());
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

}
