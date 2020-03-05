package com.greg.coupons.enums;

public enum ErrorTypes {

	GENERAL_ERROR(600, "we have encountered a technical problem and our loyal staff is working to fix it right now", "general error", false),
	
	USER_FAILED_LOGIN(601, "login error", "failed to login", false),
	USER_ALREADY_EXISTS(602, "user already exists", "user already exists", false),
	USER_FAILED_TO_CREATE(603, "failed to create user", "failed to create user", false),
	USER_FAILED_TO_UPDATE(604, "failed to update user", "failed to update user", false),
	USER_FAILED_TO_DELETE(605, "failed to delete user", "failed to delete user", false),
	USER_FAILED_TO_GET(606, "failed to get user", "failed to get user", false),
	USER_FAILED_TO_GET_ALL(607, "failed to get all users", "failed to get all users", false),
	
	CUSTOMER_ALREADY_EXISTS(608, "customer already exists", "mock2", false),
	CUSTOMER_FAILED_TO_CREATE(609, "failed to create customer", "failed to create customer", false),
	CUSTOMER_FAILED_TO_UPDATE(610, "failed to update customer", "failed to update customer", false),
	CUSTOMER_FAILED_TO_DELETE(611, "failed to delete customer", "failed to delete customer", true),
	CUSTOMER_FAILED_TO_GET(612, "failed to get customer", "failed to get customer", false),
	CUSTOMER_FAILED_TO_GET_ALL(613, "failed to get all customers", "failed to get all customers", false),
	
	COMPANY_ALREADY_EXISTS(614, "mock", "mock2", false),
	COMPANY_FAILED_TO_CREATE(615, "failed to create company", "failed to create company", false),
	COMPANY_FAILED_TO_UPDATE(616, "failed to update company", "failed to update company", false),
	COMPANY_FAILED_TO_DELETE(617, "failed to delete company", "failed to delete company", false),
	COMPANY_FAILED_TO_GET(618, "failed to get company", "failed to get company", false),
	COMPANY_FAILED_TO_GET_ALL(619,"failed to get all companie", "failed to get all companies", false),

	COUPON_ALREADY_EXISTS(620, "mock", "mock2", false),
	COUPON_FAILED_TO_CREATE(621, "failed to create coupon", "failed to create coupon", false),
	COUPON_FAILED_TO_UPDATE(622, "failed to update coupon", "failed to update coupon", false),
	COUPON_FAILED_TO_DELETE(623, "failed to delete coupon", "failed to delete coupon", false),
	COUPON_FAILED_TO_GET(624, "failed to get coupon", "failed to get coupon", false),
	COUPON_FAILED_TO_GET_ALL(625, "failed to get all coupons", "failed to get all coupons", false),
	
	PURCHASE_FAILED_TO_CREATE(626, "failed to create purchase", "failed to create purchase", false),
	PURCHASE_FAILED_TO_UPDATE(627, "failed to update purchase", "failed to update purchase", false),
	PURCHASE_FAILED_TO_DELETE(628, "mock", "mock2", false),
	PURCHASE_FAILED_TO_GET(629, "failed to get purchase", "failed to get purchase", false),
	PURCHASE_FAILED_TO_GET_ALL(630, "failed to get all purchases", "failed to get all purchases", false),
	
	RESULT_SET_FAILURE(631, "comething went wrong with the result set", "result set failure", false);
	

	
	
	
	
	
	
	private int errorNumber;
	private String errorMessage;
	private String errorName;
	private boolean isShowStackTrace;

	
	
	
	private ErrorTypes() {
		
	}
	
	
	
	private ErrorTypes(int errorNumber, String errorMessage, String errorName, boolean isShowStackTrace) {
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
		this.errorName = errorName;
		this.isShowStackTrace = isShowStackTrace;
	}
	
	
	
	public int getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public boolean isShowStackTrace() {
		return isShowStackTrace;
	}
	public void setShowStackTrace(boolean isShowStackTrace) {
		this.isShowStackTrace = isShowStackTrace;
	}
	
	
}
