package dao;

import java.util.List;

import modal.Cart;
import modal.Customer;
import DB.CustomerData;
import Enum.Status;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public List<Customer> getAllCustomer() {
		return CustomerData.getInstance().getAllCustomer();
	}


	@Override
	public Status saveCustomer(Customer customer) {
		return CustomerData.getInstance().saveCustomer(customer);
	}

	@Override
	public Status deleteCustomer(int index) {
		return CustomerData.getInstance().deleteCustomer(index);
	}

	@Override
	public Status updateCustomer(Customer customer, String name,String address, String email, String phone, Cart cart) {
		return CustomerData.getInstance().updateCustomer(customer, name, address, email, phone, cart);
	}
	
	
	
	
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
