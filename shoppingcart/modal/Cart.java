package modal;

import java.util.ArrayList;
import java.util.List;

import modal.CartItem;
import modal.Customer;

public class Cart {
	
	private int cartId;
	private List<CartItem> cartItems;
	private static int id=1;
	
	
	private Customer customer;//cart's user
	
	public Cart(Customer customer){
		this.cartId = genrateUniqueId();
		this.customer = customer;
		this.cartItems = new ArrayList<CartItem>();
	}
	
	/*
	 * @return cartId
	 * */
	public int getId(){
		return this.cartId;
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
   	 * @return cartItems list of Item added in cart 
   	 * */
    public List<CartItem> getCartItems() {
        return this.cartItems;
    }
    
    
	 /*
     * @param pId cartItem Id
     * @return cartItem cartItem which found in cart by id 
     *     else "null" if not found in cart
     * */
    public CartItem getItemById(int pId) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getId()==(pId)) {
                return cartItem;
            }
        }
        return null;
    }
    
    /*
   	 * @param Item 
   	 * */
    public void addItem(CartItem cartItem){
    	this.cartItems.add(cartItem);
    }
    
    /*
   	 * @param index of item in item list 
   	 * */
    public void deleteItem(int index){
    	this.cartItems.remove(index);
    }
    
    
    /*
     * @return id unique id for each user
     * */
    private static int genrateUniqueId(){
    	return id++;//static instance variable
    }
   
}
