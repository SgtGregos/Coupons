package com.greg.coupons.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	private Long customerId;
	
	@OneToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@MapsId
	private User user;

	@Column(name = "AMOUNT_OF_KIDS", nullable = false)
	private int amountOfKids;

	@Column(name = "IS_MARRIED", nullable = false)
	private boolean isMarried;

	@Column ( name = "CUSTOMERS_FIRST_NAME", nullable = false)
	private String customerFirstName;

	@Column(name = "CUSTOMERS_LAST_NAME", nullable = false)
	private String customerLastName;
	
	
	@JsonIgnore
	@OneToMany (mappedBy = "customerId", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List <Purchase> purchases;
	
	
	public Customer() {
		
	}
	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAmountOfKids() {
		return amountOfKids;
	}

	public void setAmountOfKids(int amountOfKids) {
		this.amountOfKids = amountOfKids;
	}

	public boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}


	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}


	public Long getId() {
		return customerId;
	}



	public void setId(Long customerId) {
		this.customerId = customerId;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", user=" + user + ", amountOfKids=" + amountOfKids
				+ ", isMarried=" + isMarried + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", purchases=" + purchases + "]";
	}
	
	





}
