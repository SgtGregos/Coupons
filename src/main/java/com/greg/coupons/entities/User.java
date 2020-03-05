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
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="USERTYPE", nullable=false)
	@Enumerated (EnumType.STRING)
	private UserType userType;
	
	@Column(name="USERPHONE", nullable=true)
	private long userPhone;
	
	@Column(name="COMPANYID", nullable=true)
	private Long companyId;
	@JsonIgnore
	@ManyToOne
	private Company company;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Customer customer;
	
	
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

	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ ", userPhone=" + userPhone + ", companyId=" + companyId + ", company=" + company + ", customer="
				+ customer + "]";
	}
	
	
	

}
