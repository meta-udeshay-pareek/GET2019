package factory;

import modal.Cart;
import modal.Customer;

public class CartFactory {

	/*
	 * @return Object of cart form a particular customer
	 *  */
	public static Cart getCartInstance(Customer customer){
		return new Cart(customer);
	}
}
