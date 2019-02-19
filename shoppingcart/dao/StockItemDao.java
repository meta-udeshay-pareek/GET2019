package dao;

import modal.Product;
import Enum.Status;

public interface StockItemDao extends BaseDao {
	public Status updateQuantity(Product product,int quantity);
}
