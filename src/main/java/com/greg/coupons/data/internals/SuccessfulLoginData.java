package com.greg.coupons.data.internals;

import com.greg.coupons.enums.UserType;

public class SuccessfulLoginData {
	//-------------------------------------------
	private int token;
	private UserType userType;
	//-------------------------------------------
	public SuccessfulLoginData(int token, UserType userType) {
		super();
		this.token = token;
		this.userType = userType;
	}
	
	public SuccessfulLoginData() {

	}
	//-------------------------------------------

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "SuccessfulLoginData [token=" + token + ", userType=" + userType + "]";
	}
	
	
}
