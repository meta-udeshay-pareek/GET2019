package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet resultSet, int i) throws SQLException {

		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setFirstName(resultSet.getString("first_name"));
		user.setLastName(resultSet.getString("last_name"));
		user.setContactNo(resultSet.getString("contact_no"));
		user.setEmail(resultSet.getString("email"));
		return user;
	}
}
