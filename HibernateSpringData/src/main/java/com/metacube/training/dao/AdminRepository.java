package com.metacube.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
//	List<Admin> findByUserName(String userName);
}
