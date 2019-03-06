package com.metacube.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByLastName(String lastName);
	List<User> findByFirstName(String firstName);
	List<User> findByContactNo(String contactNo);
	List<User> findByEmail(String email);
}
