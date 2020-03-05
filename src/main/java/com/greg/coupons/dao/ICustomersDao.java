package com.greg.coupons.dao;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.Customer;

public interface ICustomersDao extends CrudRepository<Customer, Long> {
	
	public boolean existsByCustomerLastName(String customerName);
	
	public boolean existsByCustomerId(long customerId);
	
	

}
