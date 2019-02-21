package DB;

import java.util.ArrayList;
import java.util.List;

import Enum.Status;
import modal.Cart;
import modal.Customer;

public class CustomerData {

	List<Customer> customerList;//all customer will store here
	
	
	private static CustomerData customerData;//Reference variable of this class
	
	private CustomerData(){
		customerList =  new ArrayList<Customer>();
	}
	
	
	/*
	 * @return customerData instance of this class
	 * */
	
	public static CustomerData getInstance(){
		
		if(customerData==null){
			customerData= new CustomerData();
		}
		
		return customerData;
	}
	
	/*
	 * @param customer for saving customer in list
	 * @return Status , the status of adding customer in list
	 * */
	public Status saveCustomer(Customer customer){
		this.customerList.add(customer);//adding customer into list
		return Status.SUCCESS;
	}
	
	/*
	 * @param index the index of customer in customer list which we need to delete
	 * @return Status , the status of deleting a customer from list
	 * */
	public Status deleteCustomer(int index){
		this.customerList.remove(index);//deleting customer from list by index of customer
		return Status.SUCCESS;
	}
	
	/*
	 *  @return customerList , all the customer stored in list
	 *  */
	public List<Customer> getAllCustomer(){
		return this.customerList;
	}
	
	/*
	 * @param cart,in which cart we need to do updation
	 * @param cartItems,cartItems list  updation in cart
	 *
	 * @return Status.Success
	 * */
	public Status updateCustomer(Customer customer,String name,String address,String email,String phone,Cart cart){
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setCart(cart);
		
		return Status.SUCCESS;
	}
}
