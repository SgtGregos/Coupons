package com.greg.coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.entities.Company;
import com.greg.coupons.entities.CompanyUserRegisterDetails;
import com.greg.coupons.logic.CompaniesController;

@RestController
@RequestMapping("/companies")
public class CompaniesApi {
	//-----------------------------------------------------------------------------------------------------
	@Autowired
	private CompaniesController companiesController;
	//-----------------------------------------------------------------------------------------------------
	@PostMapping
	public void createCompany(@RequestBody Company company) throws ApplicationException{
		this.companiesController.createCompany(company);
	}
	//-----------------------------------------------------------------------------------------------------
	//  URL : http://localhost:8080/companies
	@PutMapping
	public void updateCompany(@RequestBody Company company) throws Exception {
		this.companiesController.updateCompany(company);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/companies/12
	@GetMapping("{userId}")
	public Company getCompany(@PathVariable("userId") long id) throws Exception {
		return this.companiesController.getCompany(id);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/companies/12
	@DeleteMapping("{userId}")
	public void deleteCompany(@PathVariable("userId") long id) throws Exception {
		this.companiesController.deleteCompany(id);
	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping
	public List<Company> getAllUsers(Company company) throws Exception{
		
		return this.companiesController.getAllCompanies(company);

	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping("/companyTypes")
	public List<String> getCompanyTypes() throws Exception{
		
		return this.companiesController.getAllCompanyTypes();
		
	}
	//-----------------------------------------------------------------------------------------------------
	@PostMapping("/createCompanyUser")
	public void createCompanyUser(@RequestBody CompanyUserRegisterDetails companyUserRegisterDetails) throws ApplicationException{
		this.companiesController.createCompanyUser(companyUserRegisterDetails);
	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping("/getAllCompaniesNames")
	public List<String> getAllCompaniesNames() throws Exception{
		
		return this.companiesController.getAllCompaniesNames();
		
	}
	//-----------------------------------------------------------------------------------------------------
	@PutMapping("/deleteSelectedCompany")
	public void deleteSelectedCompany(@RequestBody String companyName) throws Exception{
		
	 this.companiesController.deleteSelectedCompany(companyName);
		
	}
}
