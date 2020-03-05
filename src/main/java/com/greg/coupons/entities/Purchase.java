package com.greg.coupons.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Purchase {
	//------------class-variables-----------------------------------------------------------------------------------------
	
	@Column(name = "CUSTOMER_ID", nullable = false)
	private long customerId;
	
	@Column(name = "COUPON_ID", nullable = false)
	private long couponId;
	
	@Id
	@GeneratedValue
	private long purchaseId;
	
	@Column(name = "PURCHASE_AMOUNT", nullable = false)
	private int purchaseAmount;
	
	@Column(name = "COUPON_PRICE", nullable = false)
	private long couponPrice;
	
	@UpdateTimestamp
	@Column(name = "PURCHASE_DATE", nullable = false)
	private Timestamp purchaseDate;
	
	@Column(name = "COUPON_NAME", nullable = false)
	private String couponName;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Coupon coupon;
	//-------------constructor----------------------------------------------------------------------------------------
	public Purchase() {

	}
	//---------------------Getters-and-Setters--------------------------------------------------------------------------------
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getCouponId() {
		return couponId;
	}
	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}
	public long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp date) {
		this.purchaseDate = date;
	}
	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	
	public long getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(long couponPrice) {
		this.couponPrice = couponPrice;
	}
	@Override
	public String toString() {
		return "Purchase [customerId=" + customerId + ", couponId=" + couponId + ", purchaseId=" + purchaseId
				+ ", purchaseAmount=" + purchaseAmount + ", couponPrice=" + couponPrice + ", purchaseDate="
				+ purchaseDate + ", couponName=" + couponName + ", coupon=" + coupon + "]";
	}


}
