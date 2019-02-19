package factory;


import modal.CartItem;
import modal.Product;

public class CartItemFactory {

	/*
	 * @param product
	 * @return Object of CartItem
	 *  */
	public static CartItem getCartItemInstance(Product product,int quantity){
		CartItem cartItem= new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		
		return cartItem;
	}
}
