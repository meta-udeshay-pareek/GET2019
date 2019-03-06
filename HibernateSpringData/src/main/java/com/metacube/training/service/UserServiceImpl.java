package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.UserRepository;
import com.metacube.training.model.User;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;
	
	
	/*
	 * @param user
	 * @return status of saving user in database
	 * */
	public boolean add(User user) {
		userRepository.save(user);
		return true;
	}

	/*
	 * @param id
	 * @return user
	 * */
	public User getById(Integer id) {
		return userRepository.findOne(id);
	}

	/*
	 * @param user
	 * @return status of updating user in database
	 * */
	public boolean update(User user) {
		
		//getting user based on id
		User tempUser = userRepository.findOne(user.getId());
		
		//setting all the updated data in user information
		tempUser.setContactNo(user.getContactNo());
		tempUser.setEmail(user.getEmail());
		tempUser.setFirstName(user.getFirstName());
		tempUser.setLastName(user.getLastName());
		
		//saving updated user
		userRepository.save(tempUser);
		
		return true;
		
	}

	/*
	 * 
	 * @return users
	 * */
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	/*
	 * @param id
	 * @return status of deleting user in database
	 * */
	public boolean delete(Integer id) {
		userRepository.delete(id);
		return true;
	}



	/*
	 * @param searchUserBy
	 * @param userInfo
	 * @return users
	 * */
	public List<User> searchBy(String searchUserBy,String userInfo) {
		
		if(searchUserBy.equals("firstName")) {
			return userRepository.findByFirstName(userInfo);
		}else if(searchUserBy.equals("lastName")) {
			return userRepository.findByLastName(userInfo);
		}else if (searchUserBy.equals("contactNo")){
			return userRepository.findByContactNo(userInfo);
		}else if (searchUserBy.equals("email")){
			return userRepository.findByEmail(userInfo);
		}
		
		return null;
		
	}

	
}
