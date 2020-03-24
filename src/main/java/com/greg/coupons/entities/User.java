package com.greg.coupons.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greg.coupons.enums.UserType;

@Entity
@Table(name="Users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="USERID")
	private long userId;
	
	@Column(name="USERNAME", unique=true, nullable=false)
	private String userName;
	
	@Column(name="EMAIL", unique=false, nullable=false)
	private String eMail;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="USERTYPE", nullable=false)
	@Enumerated (EnumType.STRING)
	private UserType userType;
	
	@Column(name="USERPHONE", nullable=true)
	private long userPhone;
	
	@ManyToOne
	private Company company;
	
	
	
	public User() {
		super();
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", eMail=" + eMail + ", password=" + password
				+ ", userType=" + userType + ", userPhone=" + userPhone + ", company=" + company + "]";
	}
	
	
	

}
