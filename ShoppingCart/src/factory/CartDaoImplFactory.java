package factory;

import dao.CartDaoImpl;

public class CartDaoImplFactory {

	 public static CartDaoImpl getCartDaoImplInstance(){
			return new CartDaoImpl();
	 }
}
