package factory;

import modal.Customer;

public class CustomerFactory {
	
	/*
	 * @param name customer name
	 * @param address customer address
	 * @param email customer email
	 * @param phone customer phone number
	 * 
	 * @return customer customer object
	 * */
	public static Customer getCustomerInstance(String name,String address,String email,String phone){
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPhone(phone);
		
		
		return customer;
	}
}
