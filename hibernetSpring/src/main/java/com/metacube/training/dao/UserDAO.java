package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.User;

public interface UserDAO {

	public boolean add(User user);

	public User get(Integer id);

	public boolean update(User user);

	public List<User> getAll();

	public boolean delete(Integer id);

	public List<User> searchBy(String searchBy, String value);

	public boolean isAdminExist(String username, String userpassword);
}
