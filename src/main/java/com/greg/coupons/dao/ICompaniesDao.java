package com.greg.coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.Company;

public interface ICompaniesDao  extends CrudRepository<Company, Long>{
	
	public boolean existsByCompanyName(String companyName);
	
	public boolean existsByCompanyId(long companyId);

	
	
}
