package factory;

import modal.Cart;
import modal.CartItem;
import modal.Customer;
import modal.Product;
import modal.Stock;
import modal.StockItem;
import dao.CartDaoImpl;
import dao.CartItemDaoImpl;
import dao.CustomerDaoImpl;
import dao.StockItemDaoImpl;

public class Factory {

	public static CartDaoImpl getCartDaoImplInstance(){
		return new CartDaoImpl();
	}
	
	/*
	 * @return Object of cart form a particular customer
	 *  */
	public static Cart getCartInstance(Customer customer){
		Cart cart = new Cart();
		cart.setCustomer(customer);
		return cart;
	}
	
	public static CartItemDaoImpl getCartItemDaoImplInstance(){
		return new CartItemDaoImpl();
	}
	
	/*
	 * @param product
	 * @return Object of CartItem
	 *  */
	public static CartItem getCartItemInstance(Product product,int quantity,int cartId){
		CartItem cartItem= new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		cartItem.setCartId(cartId);
		
		return cartItem;
	}
	
	public static CustomerDaoImpl getCustomerDaoImplInstance(){
		return new CustomerDaoImpl();
	}
	
	/*
	 * @param name customer name
	 * @param address customer address
	 * @param email customer email
	 * @param phone customer phone number
	 * 
	 * @return customer customer object
	 * */
	public static Customer getCustomerInstance(String name,String address,String email,String phone){
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPhone(phone);
		
		
		return customer;
	}
	
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
	
	/*
	 * @return stock  instance of Stock class
	 * */
	public static Stock getStockInstance(){
		//as Stock is singleton class so we have to get it instance from method
		return Stock.getInstance();
	}
	
	public static StockItemDaoImpl getStockItemDaoImplInstance(){
		return new StockItemDaoImpl();
	}
	
	/*
	 * @param product
	 * @return Object of StockItem
	 *  */
	public static StockItem getStockItemInstance(Product product,int quantity){
		StockItem stockItem= new StockItem();
		stockItem.setProduct(product);
		stockItem.setQuantity(quantity);
		
		return stockItem;
	}
}
