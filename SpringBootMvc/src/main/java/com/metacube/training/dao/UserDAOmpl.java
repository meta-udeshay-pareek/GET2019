package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.AdminMapper;
import com.metacube.training.mapper.UserMapper;
import com.metacube.training.model.Admin;
import com.metacube.training.model.User;

@Repository
public class UserDAOmpl implements UserDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND = "select * from user where id = ?";
private final String SQL_DELETE = "delete from user where id = ?";
private final String SQL_UPDATE = "update user set firstName = ?, lastName = ?, contactNo  = ?, email  = ? where id = ?";
private final String SQL_GET_ALL = "select * from user";
private final String SQL_INSERT = "insert into user(firstName, lastName, contactNo, email) values(?,?,?,?)";
private final String SQL_SEARCH_IN_ADMIN = "select * from admin where username = ? AND password = ?";
//private final String SQL_SEARCH = "select * from user where ? = ?";


	//@Autowired which is configured with database.properties class
	// all the information is defined in database.properties class and from there dataSource is initializing
	@Autowired
	public UserDAOmpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * @param user
	 * @return boolean
	 *  	jdbcTemplate.update() returns number of updated rows,if that is greater than 0 then it will return true else false
	 * */
	public boolean add(User user) {
		//this update method returns no. of effected rows
		return jdbcTemplate.update(SQL_INSERT, user.getFirstName(), user.getLastName(), user.getContactNo(),user.getEmail()) > 0;
	}

	/*
	 * @param id
	 * @return user object
	 * Searching user by id ,after fetching whole row for this id in db, mapper is mapping it with user object
	 * */
	public User get(Integer id) {
		return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new UserMapper());
	}

	/*
	 * @param user
	 *@return boolean
	 *  	jdbcTemplate.update() returns number of updated rows,if that is greater than 0 then it will return true else false
	 * */
	public boolean update(User user) {
		return jdbcTemplate.update(SQL_UPDATE, user.getFirstName(), user.getLastName(), user.getContactNo(),
				user.getLastName(),user.getId()) > 0;
	}

	/*
	 * @return List of User which is Mapped by Mapper
	 * */
	public List<User> getAll() {
		return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
	}

	/*
	 * @param id
	 * *@return boolean
	 *  	jdbcTemplate.update() returns number of updated rows,if that is greater than 0 then it will return true else false
	 *   */
	public boolean delete(Integer id) {
		return jdbcTemplate.update(SQL_DELETE, id) > 0;
	}

	/*
	 * @param searchUserBy, by which info user searching will happen
	 * @param userInfo,userInfo like phone number or firstName etc
	 * @return List of User which is Mapped by Mapper
	 * */
	@Override
	public  List<User> searchBy(String searchUserBy,String userInfo) {
		String SQL_SEARCH = "select * from user where "+searchUserBy+" = "+"\""+ userInfo +"\"";
		return jdbcTemplate.query(SQL_SEARCH,new UserMapper());
	}
	/*
	 * @param username, 
	 * @param username,
	 * @return "true" if any admin with these credentials exist else "false"
	 * */
	@Override
	public boolean isAdminExist(String username, String userpassword) {
		List<Admin> admins = jdbcTemplate.query(SQL_SEARCH_IN_ADMIN,new Object[] { username,userpassword },new AdminMapper());
		return admins.size()>0;
	}
}
