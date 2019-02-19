package dao;

import java.util.List;

import modal.CartItem;
import Enum.Status;

public interface CartDao {
	public List<CartItem> getAllItem();
	public CartItem getItemById(int id);
	public Status addItem(CartItem cartItem);
	public Status deleteItem(CartItem cartItem);
}
