package modal;

import java.util.ArrayList;
import java.util.List;

import modal.CartItem;
import modal.Customer;

public class Cart {
	
	private int pk;//primary key
	private List<CartItem> cartItems;
	private static int id=1;//for generation of unique primary key 
	
	
	private Customer customer;//cart's user
	
	public Cart(){
		this.pk = genrateUniqueId();
		this.cartItems = new ArrayList<CartItem>();
	}
	
	/*
	 * @return cartId
	 * */
	public int getId(){
		return this.pk;
	}
	
 
    /*
   	 * @return customer cart owner
   	 * */
    public Customer getCustomer() {
        return customer;
    }
 
    /*
   	 * @param customer cart owner
   	 * */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
 
    /*
   	 * @return cartItems list of cart 
   	 * */
    public List<CartItem> getCartItemList() {
        return this.cartItems;
    }
    
    /*
   	 * @param cartItems list of Item added in cart 
   	 * */
    public void setCartItemList(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
     
    
    /*
     * @return id unique id for each user
     * */
    private static int genrateUniqueId(){
    	return id++;//static instance variable
    }
   
}
