package com.greg.coupons.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.data.internals.SuccessfulLoginData;
import com.greg.coupons.data.internals.UserLoginData;
import com.greg.coupons.data.internals.UserLoginDetails;
import com.greg.coupons.entities.CompanyUserRegisterDetails;
import com.greg.coupons.entities.User;
import com.greg.coupons.entities.UserRegisterDetails;
import com.greg.coupons.logic.UsersController;

@RestController
@RequestMapping("/users")
public class UsersApi {
	//-----------------------------------------------------------------------------------------------------
	@Autowired
	private UsersController usersController;
	//-----------------------------------------------------------------------------------------------------
	@PostMapping("/login")
	public SuccessfulLoginData login(@RequestBody UserLoginDetails userLoginDetails) throws Exception{
		return this.usersController.login(userLoginDetails);
	}
	@PostMapping
	public void createUser(@RequestBody User user) throws Exception{
		this.usersController.createUser(user);
	}
	//-----------------------------------------------------------------------------------------------------
	//  URL : http://localhost:8080/users
	@PutMapping
	public void updateUser(@RequestBody User user) throws Exception {
		this.usersController.updateUser(user);
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/users/12
	@GetMapping("{userId}")
	public User getUser(@PathVariable("userId") long id) throws Exception {
		//need to change to get name String
		User user = this.usersController.getUser(id);
		return user;
	}
	//-----------------------------------------------------------------------------------------------------
	// http://localhost:8080/users/12
	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable("userId") long id) throws Exception {
		this.usersController.deleteUser(id);
	}
	//-----------------------------------------------------------------------------------------------------
	@GetMapping
	public List<User> getAllUsers() throws Exception{
		return this.usersController.getAllUsers();
	}
	//-----------------------------------------------------------------------------------------------------
	@PutMapping("/enterEMail")
	public void enterEMail(@RequestBody String eMail, HttpServletRequest request) throws Exception {
		UserLoginData userLoginData = (UserLoginData) request.getAttribute("userLoginData");
		long userId = userLoginData.getId();
		this.usersController.enterEMail(eMail,userId );
	}
	//-----------------------------------------------------------------------------------------------------
	@PostMapping("/createAdminUser")
	public void createCompanyUser(@RequestBody User  userRegisterDetails) throws ApplicationException{
		this.usersController.createAdminUser(userRegisterDetails);
	}
}
