package com.metacube.training.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.metacube.training.model.User;
import org.hibernate.criterion.Restrictions;


@Repository("userDAO")
public class UserDAOmpl extends AbstractDao<Integer,User> implements UserDAO{



	/*
	 * @param id
	 * @return user object
	 * Searching user by id 
	 * */
	public User get(Integer id){
		return getByKey(id);
	}


	/*
	 * @param user object for adding into database
	 * @return true 
	 * */
	@Override
	public boolean add(User user) {
		persist(user);
		return true;
	}


	/*
	 * @param user object for update into database
	 * @return true 
	 * */
	@Override
	public boolean update(User user) {
		getSession().update(user);
		return true;
	}


	/*
	 * @return users , list of users in database
	 * */
	@Override
	public List<User> getAll() {
		Criteria criteria = createEntityCriteria();
		List<User> users = (List<User>) criteria.list();
		return users;
	} 


	/*
	 * @param id, id for deleting User from database
	 * */
	@Override
	public boolean delete(Integer id) {
		//criteria based query for getting user based on user id
		User user = (User ) createEntityCriteria().add(Restrictions.eq("id", id)).uniqueResult();
		//calling super class method for deleting user
		delete(user);
		
		return true;
	}


	/*
	 * @param searchBy, on what basis we will search
	 * @param value,the value on basis of that we are searching
	 * @return users , list of users
	 * */
	@Override
	public List<User> searchBy(String searchBy, String value) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq(searchBy, value));
		return (List<User>) criteria.list();
	}


	

}
