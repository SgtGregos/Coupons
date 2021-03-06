package com.greg.coupons.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greg.coupons.Utils.ApplicationException;
import com.greg.coupons.Utils.Validations;
import com.greg.coupons.dao.IUsersDao;
import com.greg.coupons.data.internals.SuccessfulLoginData;
import com.greg.coupons.data.internals.UserLoginData;
import com.greg.coupons.data.internals.UserLoginDetails;
import com.greg.coupons.entities.CompanyUserRegisterDetails;
import com.greg.coupons.entities.Customer;
import com.greg.coupons.entities.User;
import com.greg.coupons.entities.UserRegisterDetails;
import com.greg.coupons.enums.CompanyAndCouponType;
import com.greg.coupons.enums.ErrorTypes;
import com.greg.coupons.enums.UserType;

@Controller
public class UsersController {
	//------------class variables-----------------------------------------------------------------------------------------
	@Autowired
	private IUsersDao usersDao;

	@Autowired
	private CacheController cacheController;

	@Autowired
	private Validations validations;
	//-------------constructor----------------------------------------------------------------------------------------
	public UsersController() {

	}
	//-----------------------------------------------------------------------------------------------------
	public long createUser(User user) throws ApplicationException{
		if(this.usersDao.existsByUserName(user.getUserName())) {
			throw new ApplicationException(ErrorTypes.USER_ALREADY_EXISTS, "user already exists");
		}
		if(!validations.isValid(user.geteMail())) {
			throw new ApplicationException(ErrorTypes.GENERAL_ERROR, "Invalid Email");
		}
		try {
			usersDao.save(user);
			long id = user.getUserId();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_CREATE, "Failed to create new user");

		}

	}
	//-----------------------------------------------------------------------------------------------------
	public void updateUser(User user) throws ApplicationException{
		if(this.usersDao.findById(user.getUserId()) == null) {
			throw new ApplicationException(ErrorTypes.USER_FAILED_TO_UPDATE, "could'nt update user because user not found");
		}
		if(!validations.isValid(user.geteMail())) {
			throw new ApplicationException(ErrorTypes.GENERAL_ERROR, "Invalid Email");
		}
		try {
			this.usersDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_UPDATE, "Failed to update  user");
		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void deleteUser(long id) throws ApplicationException{
		if(this.usersDao.findById(id) == null) {
			throw new ApplicationException(ErrorTypes.USER_FAILED_TO_DELETE, "could'nt delete user because user not found");
		}
		try {
			this.usersDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_DELETE, "Failed to delete  user");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public User getUser(long id) throws ApplicationException{
		try {
			User user = this.usersDao.findById(id).get();
			user.setPassword(null);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_GET, "Failed to get  user");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public List<User> getAllUsers() throws ApplicationException {

		try {
			return (List<User>) this.usersDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_GET_ALL, "Failed to get all  user");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	private static final String ENCRYPTION_TOKEN_SALT = "AASDFHSJFHJHKAAAAA-3423@#$@#$";




	public SuccessfulLoginData login(UserLoginDetails userLoginDetails ) throws ApplicationException {
		User user;
		userLoginDetails.seteMail(userLoginDetails.getUserName());
		try {
			user =  this.usersDao.findByEMailAndPassword(userLoginDetails.geteMail(), userLoginDetails.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.GENERAL_ERROR, "Failed to login");
		}
		if(user == null) {
			try {
				user =  this.usersDao.findByUserNameAndPassword(userLoginDetails.getUserName(), userLoginDetails.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ApplicationException(e, ErrorTypes.GENERAL_ERROR, "Failed to login");
			}
		}
		int token = generateToken(userLoginDetails);


		long id = user.getUserId();
		UserType tempUserType = user.getUserType();
		Long companyId;
		if(user.getCompany() == null) {
			
		 companyId = null;
		}else {
			companyId = user.getCompany().getCompanyId();
		}
		UserLoginData userLoginData = new UserLoginData(id, tempUserType, companyId);
		// The following 2 lines are equivalent, just 2 techniques on how to convert an int --> String
		//cacheController.put(token+"", userLoginData);
		cacheController.put(String.valueOf(token), userLoginData);

		return new SuccessfulLoginData(token, user.getUserType(), user.geteMail());
	}

	private int generateToken(UserLoginDetails userLoginDetails) {
		String text = userLoginDetails.getUserName() + Calendar.getInstance().getTime().toString() + ENCRYPTION_TOKEN_SALT;
		return text.hashCode();
	}
	//-----------------------------------------------------------------------------------------------------
	public void enterEMail(String eMail, long userId) throws ApplicationException{
		if(!validations.isValid(eMail)) {
			throw new ApplicationException(ErrorTypes.GENERAL_ERROR, "Invalid EMail");
		}
		User user = this.usersDao.findById(userId).get();
		user.seteMail(eMail);
		this.usersDao.save(user);

	}
	//-----------------------------------------------------------------------------------------------------
	public void createAdminUser(User userRegisterDetails) throws ApplicationException {
		User user = new User();
		user.setUserType(UserType.ADMIN);
		user.setUserPhone(userRegisterDetails.getUserPhone());
		user.setPassword(userRegisterDetails.getPassword());
		user.setUserName(userRegisterDetails.getUserName());
		if(userRegisterDetails.geteMail() == null) {
			user.seteMail("");
		}else {
			user.seteMail(userRegisterDetails.geteMail());
		}

		try {
			this.usersDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_CREATE, "Failed to create new company");
		}
	}
	//-----------------------------------------------------------------------------------------------------
	public boolean checkPassword(long customerId, String password) {
		User user = this.usersDao.findById(customerId).get();

		if(!user.getPassword().equals(password) ) {
			return false;
		}
		return true;
	}
	//-----------------------------------------------------------------------------------------------------
	public List<String> getUserIdAndType() throws ApplicationException {

		List<User> userList =	 (List<User>) this.usersDao.findAll();

		List<String> userIdAndType = new ArrayList<String>();
		for (User temp : userList) {
			if(temp.getUserType().toString() != "CUSTOMER") {
				userIdAndType.add(temp.getUserId() + " " + temp.getUserType().toString());
				
			}

		}
		try {
			return userIdAndType;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.COMPANY_FAILED_TO_GET_ALL, "Failed to get all  company");

		}
	}
	//-----------------------------------------------------------------------------------------------------
	public void  deleteSelectedUser(String userIdAndType) throws ApplicationException{

		String[] splited = userIdAndType.split("\\s+");

		long userId = Long.parseLong(splited[0]);

		try {
			this.usersDao.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e, ErrorTypes.USER_FAILED_TO_DELETE, "Failed to delete  user");

		}





	}
}
