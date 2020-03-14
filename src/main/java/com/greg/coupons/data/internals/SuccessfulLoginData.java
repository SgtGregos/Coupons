package com.greg.coupons.data.internals;

import com.greg.coupons.enums.UserType;

public class SuccessfulLoginData {
	//-------------------------------------------
	private int token;
	private UserType userType;
	private String eMail;
	//-------------------------------------------
	public SuccessfulLoginData(int token, UserType userType, String eMail) {
		super();
		this.token = token;
		this.userType = userType;
		this.eMail = eMail;
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
	

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "SuccessfulLoginData [token=" + token + ", userType=" + userType + ", eMail=" + eMail + "]";
	}
	
	
}
