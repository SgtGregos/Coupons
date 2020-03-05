package com.greg.coupons.api;

import java.util.Collection;
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
import com.greg.coupons.entities.Coupon;
import com.greg.coupons.entities.Customer;
import com.greg.coupons.entities.Purchase;
import com.greg.coupons.entities.User;
import com.greg.coupons.logic.CouponsController;
import com.greg.coupons.logic.CustomerController;
import com.greg.coupons.logic.PurchasesController;
import com.greg.coupons.logic.UsersController;

@RestController
@RequestMapping("/purchases")
public class PurchasesApi {
	//-----------------------------------------------------------------------------------------------------
	@Autowired
	private PurchasesController purchasesController;
	@Autowired
	private CouponsController couponController;
	@Autowired
	private UsersController usersController;
	//-----------------------------------------------------------------------------------------------------
	@PostMapping
	public void createPurchase(@RequestBody Purchase purchase, HttpServletRequest request) throws Exception{
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long customerId = userLoginData.getId();
		this.purchasesController.addCouponPurchase(purchase, customerId);
	}
	//-----------------------------------------------------------------------------------------------------
	//  URL : http://localhost:8080/purchase
	@PutMapping
	public void updatePurchase(@RequestBody Purchase purchase) throws Exception {
		this.purchasesController.updatePurchase(purchase);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/purchase/12
	@GetMapping("{userId}")
	public Purchase getPurchase(@PathVariable("userId") long id) throws Exception {
		return this.purchasesController.getPurchase(id);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/purchase/12
	@DeleteMapping("{userId}")
	public void deleteCouponPurchase(@PathVariable("userId") long id) throws Exception {
		this.purchasesController.deleteCouponPurchase(id);
	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping
	public List<Purchase> getAllPurchases(Purchase purchase) throws Exception{

		return this.purchasesController.getAllPurchases(purchase);

	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping("/customersCoupons")
	public Collection<Coupon> getCustomersCoupons(HttpServletRequest request) throws Exception{
		
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long customerId = userLoginData.getId();
		Collection<Coupon> couponsList = this.purchasesController.getCustomersCoupons(customerId);
		return couponsList;
	}
}

