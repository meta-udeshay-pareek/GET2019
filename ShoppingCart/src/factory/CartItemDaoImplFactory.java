/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.CartItemDaoImpl;

/**
 *
 * @author udeshay
 */
public class CartItemDaoImplFactory {
    public static CartItemDaoImpl getCartItemDaoImplInstance(){
		return new CartItemDaoImpl();
	}
}
