package dao;

import Enum.Status;
import modal.Customer;
import modal.Product;

public interface ProductDao extends BaseDao {
	public Status updateName(Product product,String name);
	public Status updatePrice(Product product,double price);
}
