package com.greg.coupons.entities;

import com.greg.coupons.enums.UserType;

public class CompanyUserRegisterDetails {


	public UserType  userType;
	public long companyId ;
	public long userPhone ;

	public UserRegisterDetails userRegisterDetails;

	public CompanyUserRegisterDetails() {
		super();
		this.userType = userType;
		this.companyId = companyId;
		this.userPhone = userPhone;
		this.userRegisterDetails = userRegisterDetails;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public UserRegisterDetails getUserRegisterDetails() {
		return userRegisterDetails;
	}

	public void setUserRegisterDetails(UserRegisterDetails userRegisterDetails) {
		this.userRegisterDetails = userRegisterDetails;
	}
	
	

}
