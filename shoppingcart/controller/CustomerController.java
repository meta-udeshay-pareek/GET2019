package controller;

import facade.CustomerService;
import Enum.Status;
import modal.Customer;

public class CustomerController {

	
	
	public static Customer getCustomerById(int id){
		//calling facade/service
		return CustomerService.getCustomerById(id);
	}
}
