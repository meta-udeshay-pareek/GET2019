package dao;

import java.util.List;

import Enum.Status;
import modal.Cart;
import modal.Customer;


public interface CustomerDao{
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public Status saveCustomer(Customer customer);
	public Status deleteCustomer(int index);
	public Status updateCustomer(Customer customer,String name,String address,String email,String phone,Cart cart);
	
}
