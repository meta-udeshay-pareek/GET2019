package factory;

import modal.Product;

public class ProductFactory {

	/*
	 * @param name product name
	 * @param price product price
	 * @param type product type
	 *
	 * 
	 * @return product Product object
	 * */
	public static Product getProductInstance(String name,double price,String type){
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setType(type);
	
		
		return product;
	}
}
