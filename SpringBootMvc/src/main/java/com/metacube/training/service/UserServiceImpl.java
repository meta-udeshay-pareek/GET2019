package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.UserDAO;
import com.metacube.training.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public boolean add(User user) {
		return userDAO.add(user);
	}

	public User get(Integer id) {
		return userDAO.get(id);
	}

	public boolean update(User user) {
		return userDAO.update(user);
	}

	public List<User> getAll() {
		return userDAO.getAll();
	}

	public boolean delete(Integer id) {
		return userDAO.delete(id);
	}

	@Override
	public List<User> searchBy(String searchUserBy,String userInfo) {
		return userDAO.searchBy(searchUserBy,userInfo);
		
	}

	@Override
	public boolean isUserExist(String username, String userpassword) {
		return userDAO.isAdminExist(username,userpassword);
	}
}
