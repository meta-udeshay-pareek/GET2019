package DB;

import java.util.ArrayList;
import java.util.List;

import Enum.Status;
import modal.Cart;
import modal.CartItem;
import modal.Customer;


//singletonCLass
public class CartData {

	List<Cart> cartList;//all cart will store here
	
	private static CartData cartData;//Reference variable of this class
	
	private CartData(){
		cartList = new ArrayList<Cart>();
	}
	
	
	/*
	 * @return cartData instance of this class
	 * */
	
	public static CartData getInstance(){
		
		if(cartData==null){
			cartData= new CartData();
		}
		
		return cartData;
	}
	
	/*
	 * @param cart for saving cart in list
	 * @return Status , the status of adding cart in list
	 * */
	public Status saveCart(Cart cart){
		this.cartList.add(cart);//adding cart into list
		return Status.SUCCESS;
	}
	
	/*
	 * @param index the index of cart in cart list which we need to delete
	 * @return Status , the status of deleting a cart from list
	 * */
	public Status deleteCart(int index){
		this.cartList.remove(index);//deleting cart from list by index of cart
		return Status.SUCCESS;
	}
	
	/*
	 *  @return cartList , all the cart stored in list
	 *  */
	public List<Cart> getAllCart(){
		return this.cartList;
	}
	
	/*
	 * @param cart,in which cart we need to do updation
	 * @param cartItems,cartItems list  updation in cart
	 *
	 * @return Status.Success
	 * */
	public Status updateCart(Cart cart,List<CartItem> cartItems,Customer customer){
		cart.setCartItemList(cartItems);
		cart.setCustomer(customer);
		return Status.SUCCESS;
	}
}
