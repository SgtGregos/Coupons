package com.greg.coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.Coupon;


public interface ICouponsDao extends CrudRepository<Coupon, Long> {

public  List<Coupon> findByCompanyId(long id);

public  boolean existsByCouponId(long id);

public boolean existsByCouponName(String couponName);












}
