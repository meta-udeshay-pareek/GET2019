package DB;

import java.util.ArrayList;
import java.util.List;

import Enum.Status;
import modal.Product;

//singleton class
public class ProductData {
	
	List<Product> productList;//all Product will be store here
	
	private static ProductData productData;//Reference variable of this class
	
	public ProductData(){
		productList = new ArrayList<Product>();
	}
	
	
	/*
	 * @return customerData instance of this class
	 * */
	
	public static ProductData getInstance(){
		
		if(productData==null){
			productData= new ProductData();
		}
		
		return productData;
	}
	
	
	
	/*
	 * @param product for saving product in list
	 * @return Status , the status of adding product in list
	 * */
	public Status saveProduct(Product product){
		this.productList.add(product);//adding cartItem into list
		return Status.SUCCESS;
	}
	
	/*
	 * @param index the index of product in product list which we need to delete
	 * @return Status , the status of deleting a product from list
	 * */
	public Status deleteProduct(int index){
		this.productList.remove(index);//deleting cartItem from list by index of cartItem
		return Status.SUCCESS;
	}
	
	/*
	 *  @return productList , all the product stored in list
	 *  */
	public List<Product> getAllProduct(){
		return this.productList;
	}
	
	
	/*
	 * @param product,in which product we need to do updation
	 * @param price,price of product
	 * @param type,type of product
	 * @param name,name of product
	 * 
	 * @return Status.Success
	 * */
	public Status updateProduct(Product product,double price,String type,String name){
		product.setPrice(price);
		product.setType(type);
		product.setName(name);
		
		return Status.SUCCESS;
	}
}
