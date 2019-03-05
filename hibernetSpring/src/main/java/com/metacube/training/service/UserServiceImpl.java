package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.AdminDAO;
import com.metacube.training.dao.UserDAO;
import com.metacube.training.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	/*
	 * @param user
	 * @return status of saving user in database
	 * */
	public boolean add(User user) {
		return userDAO.add(user);
	}

	/*
	 * @param id
	 * @return user
	 * */
	public User get(Integer id) {
		return userDAO.get(id);
	}

	/*
	 * @param user
	 * @return status of updating user in database
	 * */
	public boolean update(User user) {
		return userDAO.update(user);
	}

	/*
	 * 
	 * @return users
	 * */
	public List<User> getAll() {
		return userDAO.getAll();
	}

	/*
	 * @param id
	 * @return status of deleting user in database
	 * */
	public boolean delete(Integer id) {
		return userDAO.delete(id);
	}



	/*
	 * @param searchUserBy
	 * @param userInfo
	 * @return users
	 * */
	public List<User> searchBy(String searchUserBy,String userInfo) {
		return userDAO.searchBy(searchUserBy,userInfo);
		
	}

	/*
	 * @param userName
	 * @param userPassword
	 * @return status
	 * */
	public boolean isUserExist(String userName, String userPassword) {
		return adminDAO.isAdminExist(userName,userPassword);
	}
}
