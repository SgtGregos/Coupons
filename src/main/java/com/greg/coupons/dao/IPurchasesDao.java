package com.greg.coupons.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.Purchase;



public interface IPurchasesDao extends CrudRepository<Purchase, Long> {
	
	public List<Purchase> findByCouponId(long couponId);
	
	public List<Purchase> findByCustomerId(long customerId);
	
	public boolean existsByCouponId(long couponId);
	
	public boolean existsByPurchaseId(long couponId);
	
	public List<Purchase> findCouponByCustomerId(long customerId);
}
