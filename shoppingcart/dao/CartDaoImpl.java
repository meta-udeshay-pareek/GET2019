package dao;

import java.util.List;

import modal.Cart;
import modal.CartItem;
import modal.Customer;
import DB.CartData;
import Enum.Status;

public class CartDaoImpl implements CartDao{

	@Override
	public List<Cart> getAllCart() {
		return CartData.getInstance().getAllCart();
	}

	@Override
	public Status saveCart(Cart cart) {
		return CartData.getInstance().saveCart(cart);
	}

	@Override
	public Status deleteCart(int index) {
		return CartData.getInstance().deleteCart(index);
	}

	@Override
	public Status updateCart(Cart cart, List<CartItem> cartItems,Customer customer) {
		return CartData.getInstance().updateCart(cart, cartItems, customer);
	}

	
	
	
	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
