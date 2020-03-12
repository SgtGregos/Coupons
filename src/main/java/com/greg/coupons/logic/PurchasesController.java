package com.greg.coupons.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.dao.ICouponsDao;
import com.greg.coupons.dao.IPurchasesDao;
import com.greg.coupons.entities.Coupon;
import com.greg.coupons.entities.Customer;
import com.greg.coupons.entities.Purchase;
import com.greg.coupons.entities.User;
import com.greg.coupons.enums.ErrorTypes;

@Controller
public class PurchasesController {
	//------------class variables-----------------------------------------------------------------------------------------
	@Autowired
	private ICouponsDao couponsDao;

	@Autowired
	private IPurchasesDao purchasesDao;
	
	@Autowired
	private UsersController usersController;
	
	@Autowired
	private CouponsController couponsController;
	//-------------constructor----------------------------------------------------------------------------------------
	public PurchasesController() {

	}
	//-----------------------------------------------------------------------------------------------------
	public void addCouponPurchase(Purchase purchase, long customerId) throws ApplicationException {
//		if (this.couponsDao.existsByCouponName(purchase.getCouponName()) == false) {
//			throw new ApplicationException(ErrorTypes.PURCHASE_FAILED_TO_CREATE, "coupon doesnt exists");
//		}
		
		System.out.println("yessss" + purchase);
		Coupon coupon = this.couponsController.getCoupon(purchase.getCouponId());
		
		System.out.println("yestus" + coupon.getCouponName());
		purchase.setCouponName(coupon.getCouponName());
		purchase.setCustomerId(customerId);
		purchase.setCouponPrice(coupon.getCouponPrice());
		purchase.setCouponId(coupon.getCouponId());
		
		
		try {
			purchasesDao.save(purchase);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_CREATE, "Failed to create new purchase");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteCouponPurchase(long id) throws ApplicationException {
		if (this.purchasesDao.existsByPurchaseId(id) == false) {
			throw new ApplicationException(ErrorTypes.PURCHASE_FAILED_TO_CREATE, "purchase failed to delete, purchase not found");
		}
		try {
			purchasesDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_DELETE, "Failed to delete  purchase");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void updatePurchase(Purchase purchase) throws ApplicationException {
		if (this.purchasesDao.existsByPurchaseId(purchase.getPurchaseId()) == false) {
			throw new ApplicationException(ErrorTypes.PURCHASE_FAILED_TO_UPDATE, "purchase failed to update, purchase not found");
		}
		try {
			purchasesDao.save(purchase);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_UPDATE, "Failed to update  purchase");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public Purchase getPurchase(long id) throws ApplicationException {

		try {
			return purchasesDao.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_GET, "Failed to get  purchase");

		}

	}
	//-----------------------------------------------------------------------------------------------------
	public List<Purchase> getAllPurchases(Purchase purchase) throws ApplicationException {

		try {
			return (List<Purchase>) this.purchasesDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_GET_ALL, "Failed to get all  purchase");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public Collection<Coupon> getCustomersCoupons(long customerId) throws ApplicationException{
		
		Set <Coupon> coupons = new HashSet<>();
		
		try {
			List <Purchase> purchases =  this.purchasesDao.findCouponByCustomerId(customerId);
		for (Purchase purchase : purchases) {
			coupons. add(couponsDao. findById(purchase.getCouponId() ).get() );
		}
		return coupons;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_GET, "Failed to get all  coupons");

		}
		
	}
	//-----------------------------------------------------------------------------------------------------
	public List<Purchase> getCustomersPurchase(long customerId) throws ApplicationException {

		try {
			return  purchasesDao.findByCustomerId(customerId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.PURCHASE_FAILED_TO_GET, "Failed to get  purchase");

		}

	}


}
