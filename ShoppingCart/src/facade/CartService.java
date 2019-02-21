package facade;


import java.util.List;

import controller.CartController;
import factory.Factory;
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
	public static Status addItemInCart(Cart cart,CartItem cartItem){
		
		List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
		
		for(CartItem item:cartItems){
			//if item is already in cart than update its quantity 
			if(item.getProduct().getId()==cartItem.getProduct().getId()){
				
				//getting cartItem by id from Cart Controller which item we have to update in cart
				CartItem UpdatingCartItem = CartController.getCartItemByIdInCart(cart, item.getId());
				
				updateCartItemInCart(cart,UpdatingCartItem,cartItem.getQuantity()+item.getQuantity());
				return Status.UPDATED;
			}
		}
		
        
        cartItems.add(cartItem);//adding item in list
        cart.setCartItemList(cartItems);//setting list to cart
        
        CartItemService.addItem(cartItem);//adding item into cartItem database as well       
        
		return Status.SUCCESS;
	}
	
	
    

	/*
	 * @param cart  on which cart we have to apply operation
     * @param pId cartItem Id
     * @return "Status.SUCCESS" if item is already in cartItem list else return "Status.NOT_EXIST"
     * */
    public static Status deleteCartItemFromCart(Cart cart,CartItem cartItem){
    	
    	int index=0;
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
    	
    	for (CartItem item : cartItems) {
    		
    		//If item found then delete it by index
            if (item.getId()==cartItem.getId()) {
                cartItems.remove(index);
                cart.setCartItemList(cartItems);//setting updated list in cart
                CartItemService.deleteItem(cartItem);//deleted item from cartItem data base as well
                return  Status.SUCCESS;
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
    public static Status updateCartItemInCart(Cart cart,CartItem cartItem,int quantity){
    	
  
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
    	
    	for (CartItem item : cartItems) {
    		//If item found then update quantity
            if (item.getId()==cartItem.getId()) {
                item.setQuantity(quantity);
                CartItemService.updateItem(item, quantity);//update item in cartItem database as well
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
    public static CartItem getCartItemByIdInCart(Cart cart,int pId) {
    	
    	List<CartItem> cartItems = cart.getCartItemList();//for traversing cartItem list
    	
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId()==(pId)) {
                return cartItem;
            }
        }
        return null;
    }
    
    
    
    public static Cart getCartById(int id){
    	List<Cart> carts = Factory.getCartDaoImplInstance().getAllCart();
    	
    	for(Cart cart : carts){
    		if(cart.getId()==id){
    			return cart;
    		}
    	}
    	
    	return null;
    }
    
    
    public static Status addCart(Cart cart){
    	return Factory.getCartDaoImplInstance().saveCart(cart);
    }
    
    
    public static Status deleteCart(Cart cart){
    	
    	int index=0;//index for cart
    	
    	//calling dao for getting list
    	List<Cart> carts = Factory.getCartDaoImplInstance().getAllCart();
    	
    	for(Cart tempCart : carts){
    		if(tempCart.getId()==cart.getId()){
    			//calling dao for deleting cart
    			return Factory.getCartDaoImplInstance().deleteCart(index);
    		}
    		index++;
    	}
    	return Status.NOT_EXIST;
    }
    
    public static List<Cart> getAllcart() {
		return Factory.getCartDaoImplInstance().getAllCart();
	}
    
    
    public static List<CartItem> getAllCartItemFromCart(Cart cart){
    	return cart.getCartItemList();			
    }
    
}
