/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;


import Enum.Status;
import factory.Factory;
import java.util.List;
import modal.CartItem;

/**
 *
 * @author udeshay
 */
public class CartItemService {
    	/*
	 *
	 * @param cartItem the item which you have to add in list
	 * 
	 * @return  "Status.SUCCESS"
	 * */
	public static  Status addItem(CartItem cartItem){
		return Factory.getCartItemDaoImplInstance().saveCartItem(cartItem);
		 
	}
	
	
    

	/*
	 * 
     * @param cartItem the item which you have to delete from list
     * @return "Status.SUCCESS" if item is already in cartItem list else return "Status.NOT_EXIST"
     * */
    public static Status deleteItem(CartItem cartItem){
    	
    	int index=0;
    	//calling dao for getting stock item list
    	List<CartItem> cartItems = Factory.getCartItemDaoImplInstance().getAllCartItem();
    	
    	
    	for (CartItem item : cartItems) {
    		
    		//If item found then delete it by index
            if (item.getId()==cartItem.getId()) {
            	//calling dao for deleting item
            	Factory.getCartItemDaoImplInstance().deleteCartItem(index);
                return Status.SUCCESS;
            }
            
            index++;//incrementing index 
        }
    	
    	return Status.NOT_EXIST;
    }
    
    
    /*
	 * @param cartItem the item which quantity you have to update in list
	 * @param quantity 
     *
     * @return "Status.SUCCESS" if item quantity has updated else return "Status.NOT_EXIST"
     * */
    public static Status updateItem(CartItem cartItem,int quantity){
    	
    	//calling dao for getting stock item list
    	List<CartItem> cartItems = Factory.getCartItemDaoImplInstance().getAllCartItem();
    	
    	
    	for (CartItem item : cartItems) {
    		//If item found then update quantity
            if (item.getId()==cartItem.getId()) {
                item.setQuantity(quantity);
                return Status.SUCCESS;
            }
            
        }
    	
    	return Status.NOT_EXIST;
    }
    
    
    /*
	 * 
     * @param pId CartItem Id
     * @return stockItem stockItem which found in Stock by id 
     *     else "null" if not found in Stock
     * */
    public static CartItem getItemById(int pId) {
    	
    	//calling dao for getting cart item list
    	List<CartItem> cartItems = Factory.getCartItemDaoImplInstance().getAllCartItem();
    	
    	for (CartItem item : cartItems) {
    		//If item found then update quantity
            if (item.getId()==pId){
               return item;
            }
            
        }
        return null;
    }
    
    
    /*
     * @return list of item which are in stock
     * */
    public static List<CartItem> getAllCartItem(){
    	//calling Dao for All cart items list
    	return Factory.getCartItemDaoImplInstance().getAllCartItem();
    }
    
}
