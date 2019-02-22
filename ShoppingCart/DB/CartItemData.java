package DB;

import java.util.ArrayList;
import java.util.List;

import modal.CartItem;
import modal.Product;
import Enum.Status;

//singleton class
public class CartItemData {

	
	List<CartItem> cartItemList;//all cartItem will store here
	
	private static CartItemData cartItemData;//Reference variable of this class
	
	public CartItemData(){
		cartItemList = new ArrayList<CartItem>();
	}
	
	
	/*
	 * @return cartItemData instance of this class
	 * */
	
	public static CartItemData getInstance(){
		
		if(cartItemData==null){
			cartItemData= new CartItemData();
		}
		
		return cartItemData;
	}
	
	
	/*
	 * @param cartItem for saving cartItem in list
	 * @return Status , the status of adding cartItem in list
	 * */
	public Status saveCartItem(CartItem cartItem){
		this.cartItemList.add(cartItem);//adding cartItem into list
		return Status.SUCCESS;
	}
	
	/*
	 * @param index the index of cart in cart list which we need to delete
	 * @return Status , the status of deleting a cart from list
	 * */
	public Status deleteCartItem(int index){
		this.cartItemList.remove(index);//deleting cartItem from list by index of cartItem
		return Status.SUCCESS;
	}
	
	/*
	 *  @return cartList , all the cart stored in list
	 *  */
	public List<CartItem> getAllCartItem(){
		return this.cartItemList;
	}
	
	/*
	 * @param cartItem,in which cartItem we need to do updation
	 * @param product,product updation in cartItem
	 * @param quantity , updation of quantity of product in cartItem
	 * 
	 * @return Status.Success
	 * */
	public Status updateCartItem(CartItem cartItem,Product product,int quantity){
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		
		return Status.SUCCESS;
	}
}
