package com.greg.coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greg.coupons.entities.Coupon;

@Repository
public interface ICouponsDao extends CrudRepository<Coupon, Long> {


public  boolean existsByCouponId(long id);

public boolean existsByCouponName(String couponName);












}
