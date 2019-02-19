package dao;

import modal.Product;
import Enum.Status;

public interface ProductDao {
	public Status updateProductname(Product product,String name);
	public Status updateProductPrice(Product product,double price);
	public Status updateProductType(Product product,String type);
}
