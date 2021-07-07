package com.metacube.facade;

import java.util.List;

import com.metacube.dao.MYSQLCategory;
import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;
import com.metacube.enums.Status;
import com.metacube.factory.DaoFactory;
import com.metacube.model.Category;

public class CategoryFacade {

	static CategoryFacade categoryfacade = new CategoryFacade();

	MYSQLCategory categorydao = (MYSQLCategory) DaoFactory.getDaoForEntity(EntityName.CATEGORY, DBType.MY_SQL);

	public static CategoryFacade getInstance() {
		return categoryfacade;
	}

	/**
	 * Function to return the insert status of the CategoryDao
	 * 
	 * @param category
	 * @return status
	 */
	public Status insertStatus(Category category) {
		boolean status = categorydao.CheckCategory(category.getName());

		if (status) {
			return Status.DUPLICATE;
		}

		categorydao.insert(category);
		return Status.CREATED;
	}

	/**
	 * Function to return the update status of the CategoryDao
	 * 
	 * @param category
	 * @return status
	 */
	public Status updateStatus(Category category) {

		categorydao.update(category);
		return Status.UPDATED;
	}

	/**
	 * Function to get the List of category
	 * 
	 * @param category
	 * @return status
	 */
	public List<Category> getList() {
		List<Category> listOfCategory = categorydao.getlist();
		return listOfCategory;
	}

	/**
	 * Function to delete the category
	 * 
	 * @param category
	 * @return status
	 */
	public Status deleteStatus(int id) {

		categorydao.deleteById(id);
		return Status.DELETED;

	}

}
