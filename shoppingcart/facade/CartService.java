package facade;


import java.util.List;

import Enum.Status;
import modal.Cart;
import modal.CartItem;

public class CartService {
	
	/*
	 * @param cart  on which cart we have to apply operation
	 * @param cartItem the item which you have to add in list
	 * 
	 * @return "Status.DUPLICATE" if item is already in cartItem list else return "Status.SUCCESS"
	 * */
	public Status addItem(Cart cart,CartItem cartItem){
		
		List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
		
		for(CartItem item:cartItems){
			//if item is already in cart than return Duplicate
			if(item.getId()==cartItem.getId()){
				return Status.DUPLICATE;
			}
		}
		
		//if item is not in cartItem list then add item in list
		cart.addItem(cartItem);
		
		return Status.SUCCESS;
	}
	
	
    

	/*
	 * @param cart  on which cart we have to apply operation
     * @param pId cartItem Id
     * @return "Status.SUCCESS" if item is already in cartItem list else return "Status.NOT_EXIST"
     * */
    public Status deleteItem(Cart cart,CartItem cartItem){
    	
    	int index=0;
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
    	
    	for (CartItem item : cartItems) {
    		
    		//If item found then delete it by index
            if (item.getId()==cartItem.getId()) {
                cart.deleteItem(index);//deleting item by index from list
                return Status.SUCCESS;
            }
            
            index++;//incrementing index 
        }
    	
    	return Status.NOT_EXIST;
    }
    
    
    /*
	 * @param cart  on which cart we have to apply operation
     * @param pId cartItem Id
     * @return "Status.SUCCESS" if item quantity has updated else return "Status.NOT_EXIST"
     * */
    public Status updatedItem(Cart cart,CartItem cartItem,int quantity){
    	
  
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
    	
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
	 * @param cart  on which cart we have to apply operation
     * @param pId cartItem Id
     * @return cartItem cartItem which found in cart by id 
     *     else "null" if not found in cart
     * */
    public CartItem getItemById(Cart cart,int pId) {
    	
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId()==(pId)) {
                return cartItem;
            }
        }
        return null;
    }
    
}
