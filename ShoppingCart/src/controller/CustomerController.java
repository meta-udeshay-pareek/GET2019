package controller;

import facade.CustomerService;
import Enum.Status;

import java.util.List;

import modal.Cart;
import modal.Customer;

public class CustomerController {

	
	
		public static Customer getCustomerById(int id){
			//calling facade/service
			return CustomerService.getCustomerById(id);
		}
        
        public static Status saveCustomer(Customer customer){
            return CustomerService.saveCustomer(customer);
        }
        
        public static Status deleteCustomer(Customer customer){
            //calling facade/service
            return CustomerService.deleteCustomer(customer);
        }
        
        public static Status updateCustomer(Customer customer, String name,String address, String email, String phone, Cart cart){
        	//calling facade/service
        	return CustomerService.updateCustomer(customer, name, address, email, phone, cart);
        }
        
        public static List<Customer> getAllCustomer(){
            //calling facade/service
            return CustomerService.getAllCustomer();
        }
}
