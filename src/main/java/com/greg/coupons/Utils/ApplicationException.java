package com.greg.coupons.Utils;

import com.greg.coupons.enums.ErrorTypes;

public class ApplicationException extends Exception {

	//--------------class-variables------------------------------------------------
	private static long IL;
	private static final long serialVersionUID = IL;
	private ErrorTypes errorType;
	//-------------------constructors-------------------------------------------
	public ApplicationException(ErrorTypes errorType, String message) {
		super(message);
		this.errorType = errorType;
	}
	
	public ApplicationException(Exception e, ErrorTypes errorType, String message) {
		super(message, e);
	}
	//--------------getter------------------------------------------------
	public ErrorTypes getErrorType() {
		return errorType;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(ErrorTypes errorType) {
		this.errorType = errorType;
	}


}
