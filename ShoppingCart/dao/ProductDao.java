package dao;

import java.util.List;
import modal.Product;
import Enum.Status;

public interface ProductDao {
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public Status saveProduct(Product product);
	public Status deleteProduct(int index);
	public Status updateProduct(Product product,double price,String type,String name);
}
