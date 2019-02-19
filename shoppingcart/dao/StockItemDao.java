package dao;

import modal.Product;
import Enum.Status;

public interface StockItemDao{
	public Status updateQuantity(Product product,int quantity);
}
