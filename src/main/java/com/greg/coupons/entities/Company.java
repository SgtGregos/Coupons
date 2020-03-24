package com.greg.coupons.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greg.coupons.enums.CompanyAndCouponType;
import com.greg.coupons.enums.UserType;

@Entity
public class Company {
	//------------class-variables-----------------------------------------------------------------------------------------
	
	@Column(name = "COMPANY_NAME", nullable = false)
	private String companyName;
	
	@Column(name = "COMPANY_ADDRESS", nullable = false)
	private String companyAddress;
	
	@Column(name = "COMPANY_TYPE", nullable = false)
	@Enumerated (EnumType.STRING)
	private CompanyAndCouponType companyType;
	
	@Id
	@GeneratedValue
	@Column(name = "COMPANY_ID", nullable = false)
	private long companyId;
	
	@Column(name = "COMPANY_PHONE", nullable = true)
	private long companyPhone;
	
	
	@Transient 
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "company")
	private List<User> users;

	
	
	@Transient
	@OneToMany ( mappedBy = "company", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List <Coupon> coupon;
	
	
	//-------------constructor----------------------------------------------------------------------------------------

	public Company() {

	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public CompanyAndCouponType getCompanyType() {
		return companyType;
	}


	public void setCompanyType(CompanyAndCouponType companyType) {
		this.companyType = companyType;
	}


	public long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}


	public long getCompanyPhone() {
		return companyPhone;
	}


	public void setCompanyPhone(long companyPhone) {
		this.companyPhone = companyPhone;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Coupon> getCoupon() {
		return coupon;
	}


	public void setCoupon(List<Coupon> coupon) {
		this.coupon = coupon;
	}


	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyAddress=" + companyAddress + ", companyType="
				+ companyType + ", companyId=" + companyId + ", companyPhone=" + companyPhone + ", users=" + users
				+ ", coupon=" + coupon + "]";
	}


	
	
	
	
	
}
