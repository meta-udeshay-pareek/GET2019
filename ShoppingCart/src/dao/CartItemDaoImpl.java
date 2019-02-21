package dao;

import java.util.List;

import modal.CartItem;
import modal.Product;
import DB.CartItemData;
import Enum.Status;

public class CartItemDaoImpl implements CartItemDao{

	@Override
	public Status saveCartItem(CartItem cartItem) {
		return CartItemData.getInstance().saveCartItem(cartItem);
	}

	@Override
	public Status deleteCartItem(int index) {
		return CartItemData.getInstance().deleteCartItem(index);
	}

	@Override
	public List<CartItem> getAllCartItem() {
		return CartItemData.getInstance().getAllCartItem();
	}

	@Override
	public Status updateCartItem(CartItem cartItem, Product product,int quantity) {
		return CartItemData.getInstance().updateCartItem(cartItem, product, quantity);
	}

}
