package com.greg.coupons.data.internals;

import com.greg.coupons.enums.UserType;

public class UserLoginData {
	private long id;
	private UserType userType;
	private Long companyId;
	
	public UserLoginData(long id, UserType tempUserType, Long companyId) {
		super();
		this.id = id;
		this.userType = tempUserType;
		this.companyId = companyId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
