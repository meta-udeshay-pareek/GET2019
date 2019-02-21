package factory;

import modal.Cart;
import modal.Customer;

public class CartFactory {

	/*
	 * @return Object of cart form a particular customer
	 *  */
	public static Cart getCartInstance(Customer customer){
		Cart cart = new Cart();
		cart.setCustomer(customer);
		return cart;
	}
}
