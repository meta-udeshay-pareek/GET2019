package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Admin;


public class AdminMapper implements RowMapper<Admin>{

	public Admin mapRow(ResultSet resultSet, int i) throws SQLException {

		Admin admin = new Admin();
		admin.setId(resultSet.getInt("id"));
		admin.setUsername(resultSet.getString("username"));
		admin.setPassword(resultSet.getString("password"));
		return admin;
	}
}
