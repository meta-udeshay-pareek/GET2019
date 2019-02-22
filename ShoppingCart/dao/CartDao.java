package dao;

import java.util.List;

import modal.Cart;
import modal.CartItem;
import modal.Customer;
import Enum.Status;

public interface CartDao {
	public List<Cart> getAllCart();
	public Cart getCartById(int id);
	public Status saveCart(Cart cart);
	public Status deleteCart(int index);
	public Status updateCart(Cart cart,List<CartItem> cartItems,Customer customer);
}
