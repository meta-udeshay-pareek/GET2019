package factory;

import dao.CustomerDaoImpl;

public class CustomerDaoImplFactory {

	public static CustomerDaoImpl getCustomerDaoImplInstance(){
		return new CustomerDaoImpl();
	}
}
