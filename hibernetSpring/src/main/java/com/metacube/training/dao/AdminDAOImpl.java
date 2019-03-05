package com.metacube.training.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Admin;

@Repository("adminDAO")
public class AdminDAOImpl extends AbstractDao<Integer,Admin> implements AdminDAO{

	/*
	 * @param username, 
	 * @param userpassword,
	 * @return "true" if any admin with these credentials exist else "false"
	 * */
	@Override
	public boolean isAdminExist(String userName, String userPassword) {
		Criteria cr = getSession().createCriteria(Admin.class);
		Criterion name = Restrictions.eq("userName", userName);
		Criterion password = Restrictions.eq("userPassword",userPassword);
		LogicalExpression andExp = Restrictions.and(name, password);
		cr.add( andExp );
		return cr.list().size()>0;
	}
}
