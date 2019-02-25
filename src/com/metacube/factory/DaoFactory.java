package com.metacube.factory;

import com.metacube.dao.BaseDao;
import com.metacube.dao.MYSQLAdvertisement;
import com.metacube.dao.MYSQLCategory;
import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;

//Factory to get object of database according to Entity name and database type
public class DaoFactory {

	@SuppressWarnings("rawtypes")
	public static BaseDao getDaoForEntity(EntityName entityName, DBType dbType) {
		BaseDao basedao = null;
		switch (entityName) {
		case CATEGORY:
			switch (dbType) {
			case MY_SQL:
				basedao = MYSQLCategory.getInstance();
			case IN_MEMORY:
				break;
			default:
				break;
			}
			break;

		case ADVERTISEMENT:
			switch (dbType) {
			case MY_SQL:
				basedao = MYSQLAdvertisement.getInstance();
			case IN_MEMORY:
				break;
			default:
				break;
			}
			break;
		}
		return basedao;
	}
}
