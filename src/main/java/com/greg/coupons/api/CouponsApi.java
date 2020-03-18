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
import com.greg.coupons.entities.Company;
import com.greg.coupons.entities.Coupon;
import com.greg.coupons.logic.CouponsController;

@RestController
@RequestMapping("/coupons")
public class CouponsApi {
	//-----------------------------------------------------------------------------------------------------
	@Autowired
	private CouponsController couponsController;
	//-----------------------------------------------------------------------------------------------------
	@PostMapping
	public void createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws Exception{
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long customerId = userLoginData.getId();
		this.couponsController.createCoupon(coupon, customerId);
	}
	//-----------------------------------------------------------------------------------------------------
	//  URL : http://localhost:8080/coupons
	@PutMapping
	public void updateCoupon(@RequestBody Coupon coupon) throws Exception {
		this.couponsController.updateCoupon(coupon);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/coupons/12
	@GetMapping("{userId}")
	public Coupon getCoupon(@PathVariable("userId") long id) throws Exception {
		return this.couponsController.getCoupon(id);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/coupons/12
	@DeleteMapping("{userId}")
	public void deleteCoupon(@PathVariable("userId") long id) throws Exception {
		this.couponsController.deleteCoupon(id);
	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping
	public List<Coupon> getAllCoupons(Coupon coupon) throws Exception{
		
		return this.couponsController.getAllCoupons(coupon);

	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping("/couponTypes")
	public List<String> getCouponTypes() throws Exception{
		
		return this.couponsController.getAllCouponTypes();
		
	}
	//-----------------------------------------------------------------------------------------------------
		@GetMapping("/companiesCoupons")
		public List<Coupon> companiesCoupons(HttpServletRequest request) throws Exception{
			UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
			long userId = userLoginData.getId();
			
			return this.couponsController.companiesCoupons(userId);
			
		}
}
