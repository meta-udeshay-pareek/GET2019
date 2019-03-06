package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.User;

public interface UserService {
	
	public boolean add(User user);
	
	public User getById(Integer id);
	
	public boolean update(User user);
	
	public List<User> getAll();
	
	public boolean delete(Integer id);

	public List<User> searchBy(String searchBy, String value);

	
}
