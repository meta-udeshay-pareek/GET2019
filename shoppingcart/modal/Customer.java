package modal;

import factory.CartFactory;
import modal.Cart;

public class Customer {

    private String name;
    private String address;
    private String email;
    private String phone;
    private int userId;
    private static int id=1;
 
    private Cart cart;//cart of customer
    
    
    public Customer(){
    	this.userId = genrateUniqueId();
    	cart = CartFactory.getCartInstance(this);//cart has created for this customer
    }
 
    /*
	 * @return name Customer name
	 * */
    public String getName() {
        return name;
    }
 
    /*
	 * @param name Customer name
	 * */
    public void setName(String name) {
        this.name = name;
    }
 
    /*
	 * @return email  Customer email
	 * */
    public String getEmail() {
        return email;
    }
 
    /*
	 * @param email  Customer email
	 * */
    public void setEmail(String email) {
        this.email = email;
    }
 

    /*
   	 * @return address  Customer address
   	 * */
    public String getAddress() {
        return address;
    }
 
    
    /*
   	 * @param address  Customer address
   	 * */
    public void setAddress(String address) {
        this.address = address;
    }
 
    /*
   	 * @return phone  Customer phone number
   	 * */
    public String getPhone() {
        return phone;
    }
 
    /*
   	 * @param phone  Customer phone number
   	 * */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    /*
     * @return cart user cart
     * */
    public Cart getCart(){
    	return this.cart;
    }
    
    /*
     * @return userId
     * */
    public int getId(){
    	return this.userId;
    }
 
    
    /********Private Method Which Generate Unique Id for Each User and It Is calling In Constructor******/
    /*
     * @return id unique id for each user
     * */
    private static int genrateUniqueId(){
    	return id++;//static instance variable
    }
}