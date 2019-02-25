package com.metacube.dao;

public interface CategoryDao extends BaseDao<com.metacube.model.Category> {
	
	
	public boolean CheckCategory(String name);
	
	public void deleteById(int id);
}
