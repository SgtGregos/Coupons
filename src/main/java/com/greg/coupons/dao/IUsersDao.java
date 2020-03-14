package com.greg.coupons.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.greg.coupons.entities.User;


public interface IUsersDao extends CrudRepository<User, Long>{

	public boolean existsByUserName(String userName);
	
	public User findByUserNameAndPassword(String userName, String password);

	public void findCompanyIdByUserId(long customerId);

	public User findByEMailAndPassword(String geteMail, String password);



}

