package com.greg.coupons.entities;

import com.greg.coupons.enums.UserType;

public class CustomerRegisterDetails {

	private UserType userType;
	private int  amountOfKids;
	private boolean isMarried;
	private long phone;
	private String customerFirstName;
	private String customerLastName;

	public UserRegisterDetails user;



	public CustomerRegisterDetails() {
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public int getAmountOfKids() {
		return amountOfKids;
	}


	public void setAmountOfKids(int amountOfKids) {
		this.amountOfKids = amountOfKids;
	}


	public boolean getIsMarried() {
		return isMarried;
	}


	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getCustomerFirstName() {
		return customerFirstName;
	}


	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}


	public UserRegisterDetails getUserRegisterDetails() {
		return user;
	}


	public void setUserRegisterDetails(UserRegisterDetails userRegisterDetails) {
		this.user = userRegisterDetails;
	}

	

	@Override
	public String toString() {
		return "CustomerRegisterDetails [userType=" + userType + ", amountOfKids=" + amountOfKids
				+ ", isMarried=" + isMarried + ", phone=" + phone + ", customerFirstName="
						+ customerFirstName + ", customerLastName=" + customerLastName + ", userRegisterDetails="
						+ user + "]";
	}





}
