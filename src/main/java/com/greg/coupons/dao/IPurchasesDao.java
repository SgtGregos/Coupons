package com.greg.coupons.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greg.coupons.entities.Purchase;


@Repository
public interface IPurchasesDao extends CrudRepository<Purchase, Long> {
	
	
	public List<Purchase> findByCustomerId(long customerId);
	
	
	public boolean existsByPurchaseId(long couponId);
	
	public List<Purchase> findCouponByCustomerId(long customerId);
}
