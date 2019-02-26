package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.UserDAO;
import com.metacube.training.mapper.UserMapper;
import com.metacube.training.model.User;

@Repository
public class UserDAOmpl implements UserDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND = "select * from user where id = ?";
private final String SQL_DELETE = "delete from user where id = ?";
private final String SQL_UPDATE = "update user set first_name = ?, last_name = ?, contact_no  = ?, email  = ? where id = ?";
private final String SQL_GET_ALL = "select * from user";
private final String SQL_INSERT = "insert into user(first_name, last_name, contact_no, email) values(?,?,?,?)";


	@Autowired
	public UserDAOmpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean add(User user) {
		
		//this update method returns no. of effected rows
		return jdbcTemplate.update(SQL_INSERT, user.getFirstName(), user.getLastName(), user.getContactNo(),user.getEmail()) > 0;
	}

	public User get(Integer id) {
		return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new UserMapper());
	}

	public boolean update(User user) {
		return jdbcTemplate.update(SQL_UPDATE, user.getFirstName(), user.getLastName(), user.getContactNo(),
				user.getLastName(),user.getId()) > 0;
	}

	public List<User> getAll() {
		return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
	}

	public boolean delete(Integer id) {
		return jdbcTemplate.update(SQL_DELETE, id) > 0;
	}
}
