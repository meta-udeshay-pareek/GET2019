package dao;

import modal.Product;
import Enum.Status;

public interface CartItemDao {
	public Status updateQuantity(Product product,int quantity);
}
