package com.greg.coupons.entities;

public class UserRegisterDetails {

	
    public String  userName;   
    public String password;
    
	public UserRegisterDetails(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public UserRegisterDetails() {

	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegisterDetails [userName=" + userName + ", password=" + password + "]";
	}    	
    
    
    
    
    
            		
}
