package facade;

import java.util.List;

import dao.CustomerDaoImpl;
import factory.CustomerDaoImplFactory;
import Enum.Status;
import modal.Customer;

public class CustomerService {

	
	/*
	 * @param id , userId for matching
	 * @return customer  if id matches with one of the customer in list else "null"
	 * */
	public static Customer getCustomerById(int id){
		//calling Dao for getting list of customer
		List<Customer> customers = CustomerDaoImplFactory.getCustomerDaoImplInstance().getAllCustomer();
		for(Customer customer:customers){
			if(customer.getId()==id){
				return customer;
			}
		}
		
		return null;
	}
}
