package dao;

import java.util.List;

import modal.Product;
import DB.ProductData;
import Enum.Status;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> getAllProduct() {
		return ProductData.getInstance().getAllProduct();
	}


	@Override
	public Status saveProduct(Product product) {
		return ProductData.getInstance().saveProduct(product);
	}

	@Override
	public Status deleteProduct(int index) {
		return ProductData.getInstance().deleteProduct(index);
	}

	@Override
	public Status updateProduct(Product product, double price, String type,String name) {
		return ProductData.getInstance().updateProduct(product, price, type, name);
	}

	
	
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
