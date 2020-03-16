package com.greg.coupons.entities;

import com.greg.coupons.enums.UserType;

public class CompanyUserRegisterDetails {


	private UserType  userType;
	private long companyId ;
	private long userPhone ;
	private String eMail;

	public UserRegisterDetails userRegisterDetails;

	public CompanyUserRegisterDetails() {
		
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "CompanyUserRegisterDetails [userType=" + userType + ", companyId=" + companyId + ", userPhone="
				+ userPhone + ", eMail=" + eMail + ", userRegisterDetails=" + userRegisterDetails + "]";
	}
	
	
	

}
