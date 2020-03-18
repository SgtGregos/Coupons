package com.greg.coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.Company;
import com.greg.coupons.entities.Coupon;

public interface ICompaniesDao  extends CrudRepository<Company, Long>{
	
	public boolean existsByCompanyName(String companyName);
	
	public boolean existsByCompanyId(long companyId);

	public Company getCompanyIdByCompanyName(String companyName);

	public List<Coupon> findAllCouponsByCompanyId(Long companyId);

	
	
}
