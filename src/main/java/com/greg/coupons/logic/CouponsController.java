package com.greg.coupons.logic;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.dao.ICouponsDao;
import com.greg.coupons.dao.IUsersDao;
import com.greg.coupons.entities.Coupon;
import com.greg.coupons.entities.User;
import com.greg.coupons.enums.CompanyAndCouponType;
import com.greg.coupons.enums.ErrorTypes;

@Controller
public class CouponsController {
	//------------class variables-----------------------------------------------------------------------------------------
	@Autowired
	private ICouponsDao couponsDao;
	
	@Autowired
	private UsersController usersController;
	//-------------constructor----------------------------------------------------------------------------------------
	public CouponsController() {

	}
	//-----------------------------------------------------------------------------------------------------
	public void createCoupon(Coupon coupon, long customerId) throws ApplicationException{
		if (couponsDao.existsByCouponId(coupon.getCouponId()) == true) {
			throw new ApplicationException(ErrorTypes.COUPON_FAILED_TO_CREATE, "coupon already exists");
		}
		
		
		
		User user = this.usersController.getUser(customerId);
		coupon.getCompany().setCompanyId(user.getCompanyId());
		
		
		try {
			this.couponsDao.save(coupon);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_CREATE, "Failed to create new coupon");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteCoupon(long id) throws ApplicationException{
		if (couponsDao.existsByCouponId(id) == false) {
			throw new ApplicationException(ErrorTypes.COUPON_FAILED_TO_DELETE, "coupon doesn't exists");
		}
		try {
			this.couponsDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_DELETE, "Failed to delete  coupon");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void updateCoupon(Coupon coupon) throws ApplicationException{
		if (couponsDao.existsByCouponId(coupon.getCouponId()) == false) {
			throw new ApplicationException(ErrorTypes.COUPON_FAILED_TO_UPDATE, "coupon doesn't exists");
		}
		try {
			this.couponsDao.save(coupon);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_UPDATE, "Failed to update  coupon");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public Coupon getCoupon(long id) throws ApplicationException{
		try {
			return this.couponsDao.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_GET, "Failed to get  coupon");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public List<Coupon> getAllCoupons(Coupon coupon) throws ApplicationException {

		try {
			return (List<Coupon>) this.couponsDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COUPON_FAILED_TO_GET_ALL, "Failed to get all  coupon");

		}

	}
	//-----------------------------------------------------------------------------------------------------
	public List<String> getAllCouponTypes() throws ApplicationException {
		
		List<String> couponTypeEnumNamesList = Stream.of(CompanyAndCouponType.values()).map(CompanyAndCouponType::name).collect(Collectors.toList());
		try {
			return couponTypeEnumNamesList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET_ALL, "Failed to get all  company");
			
		}
	}
}
