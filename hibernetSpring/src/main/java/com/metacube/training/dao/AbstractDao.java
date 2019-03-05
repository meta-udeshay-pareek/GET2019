package com.metacube.training.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable,T> {

	//for which model class we have to operation
	private final Class<T> persistentClass;

	
	/*
	 * Assigning model class to persistence class
	 * */
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	
	//Autowiring sessionFactory
	@Autowired
	private SessionFactory sessionFactory;


	/*
	 * @return Session for model class
	 * */
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/*
	 * @param  Key (PK generic type (Integer here)), for finding element based on primary key
	 * @return Model class object (User or Admin)
	 * */
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) createEntityCriteria().add(Restrictions.eq("id", key)).list();
		 
	}

	/*
	 * Saving Model (Admin or User) into databse
	 * */
	public void persist(T entity) {
		getSession().persist(entity);
	}

	/*
	 * Deleting Model (Admin or User) from database
	 * */
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/*
	 * @return Criteria object for current Model(Admin or User) class
	 * */
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
}
