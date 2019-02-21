package facade;

import java.util.List;

import controller.CartController;
import factory.CartFactory;
import factory.CustomerDaoImplFactory;
import Enum.Status;
import modal.Cart;
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
        
        public static List<Customer> getAllCustomer(){
            //calling Dao
            return CustomerDaoImplFactory.getCustomerDaoImplInstance().getAllCustomer();
        }
        
        
        
        public static Status saveCustomer(Customer customer){
        	
        	Cart cart = CartFactory.getCartInstance(customer);//creating cart for this customer
            //calling facade/service
        	CartController.saveCart(cart);//saving cart into database
        	
        	customer.setCart(cart);//setting cart for this customer
        	
        	
            //calling dao
            return CustomerDaoImplFactory.getCustomerDaoImplInstance().saveCustomer(customer);
        }
        
        
        
        public  static  Status deleteCustomer(Customer customer){
            int index=0;
            //calling Dao for getting list of customer
            List<Customer> customers = CustomerDaoImplFactory.getCustomerDaoImplInstance().getAllCustomer();
            for(Customer tempCustomer:customers){
                    if(customer.getId()==tempCustomer.getId()){
                            //calling dao for deleting customer
                            return CustomerDaoImplFactory.getCustomerDaoImplInstance().deleteCustomer(index);
                    }
                    index++;
            }
            
           return Status.NOT_EXIST; 
        }
        
        
        
        
        public static Status updateCustomer(Customer customer, String name,String address, String email, String phone, Cart cart){
            //calling Dao for updating customer
            return CustomerDaoImplFactory.getCustomerDaoImplInstance().updateCustomer(customer, name, address, email, phone, cart);
        } 
}
