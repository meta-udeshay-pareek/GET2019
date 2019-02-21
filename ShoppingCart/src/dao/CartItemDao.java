package dao;

import java.util.List;

import modal.CartItem;
import modal.Product;
import Enum.Status;

public interface CartItemDao {
	public Status saveCartItem(CartItem cartItem);
	public Status deleteCartItem(int index);
	public List<CartItem> getAllCartItem();
	public Status updateCartItem(CartItem cartItem,Product product,int quantity);
}
