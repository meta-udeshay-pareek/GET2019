package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.metacube.training.dao.AdminRepository;
import com.metacube.training.model.Admin;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	/*
	 * @param userName
	 * @param userPassword
	 * @return status
	 * */
	public boolean isAdminExist(String userName, String userPassword) {
		List<Admin> admins = adminRepository.findAll();
		if(admins.size()>0) {
			for(Admin admin:admins) {
				if(admin.getUsername().equals(userName)) {
					admin.getPassword().equals(userPassword);
					return true;
				}
			}
		}
		return false;
	}

}
