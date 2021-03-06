package com.greg.coupons.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greg.coupons.enums.CompanyAndCouponType;

@Entity
public class Coupon {
	//------------class-variables-----------------------------------------------------------------------------------------
	
	@Column(name = "COUPON_NAME", nullable = false)
	private String couponName;
	
	@Column(name = "COUPON_TYPE", nullable = false)
	@Enumerated (EnumType.STRING)
	private CompanyAndCouponType couponType;
	
	@Id
	@GeneratedValue
	private long couponId;
	
	
	
	@Column(name = "COUPON_PRICE", nullable = false)
	private long couponPrice;
	
	@Column(name = "COUPON_ACTIVATION_DATE", nullable = false)
	private Date couponActivationDate;
	
	@Column(name = "COUPON_EXPIRE_DATE", nullable = false)
	private Date couponExpireDate;
	
	@UpdateTimestamp
	@Column(name = "COUPON_CREATION_DATE", nullable = false)
	private Date couponCreationDate;
	
	@ManyToOne
	private Company company;
	
	@JsonIgnore
	@Transient
	@OneToMany (cascade = CascadeType.REMOVE, fetch = FetchType.LAZY,mappedBy = "coupon")
	private List <Purchase> purchase;
	
	
	//-------------constructor----------------------------------------------------------------------------------------

	public Coupon() {

	}
	//-------------------Getters-and-Setters----------------------------------------------------------------------------------
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public CompanyAndCouponType getCouponType() {
		return couponType;
	}
	public void setCouponType(CompanyAndCouponType couponType) {
		this.couponType = couponType;
	}
	public long getCouponId() {
		return couponId;
	}
	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}
	public Date getCouponActivationDate() {
		return couponActivationDate;
	}
	public void setCouponActivationDate(Date couponActivationDate) {
		this.couponActivationDate = couponActivationDate;
	}
	public Date getCouponExpireDate() {
		return couponExpireDate;
	}
	public void setCouponExpireDate(Date couponExpireDate) {
		this.couponExpireDate = couponExpireDate;
	}
	public Date getCouponCreationDate() {
		return couponCreationDate;
	}
	public void setCouponCreationDate(Date couponCreationDate) {
		this.couponCreationDate = couponCreationDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public List<Purchase> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
	public long getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(long couponPrice) {
		this.couponPrice = couponPrice;
	}
	@Override
	public String toString() {
		return "Coupon [couponName=" + couponName + ", couponType=" + couponType + ", couponId=" + couponId
				+ ", couponPrice=" + couponPrice + ", couponActivationDate=" + couponActivationDate
				+ ", couponExpireDate=" + couponExpireDate + ", couponCreationDate=" + couponCreationDate + ", company="
				+ company + ", purchase=" + purchase + "]";
	}
	
	

}
