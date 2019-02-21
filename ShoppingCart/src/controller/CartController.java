/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Enum.Status;
import facade.CartService;


import java.util.List;

import modal.Cart;
import modal.CartItem;

/**
 *
 * @author udeshay
 */
public class CartController {
	
        public static Cart getCartById(int id){
			//calling facade/service
			return CartService.getCartById(id);
        }
        
        public static Status saveCart(Cart cart){
            //calling facade/service
            return CartService.addCart(cart);
        }
        
        public static Status deleteCart(Cart cart){
            //calling facade/service
            return CartService.deleteCart(cart);
        }
        
        public static List<Cart> getAllCart(){
            //calling facade/service
            return CartService.getAllcart();
        }
        
        
        public static Status addCartItemInCart(Cart cart,CartItem cartItem){
        	return CartService.addItemInCart(cart, cartItem);//adding Item in cart
        }
        
        public static Status deleteCartItemFromCart(Cart cart,CartItem cartItem){
        	return CartService.deleteCartItemFromCart(cart, cartItem);
        }
        
        public static Status updateCartItemInCart(Cart cart,CartItem cartItem,int quantity){
        	return CartService.updateCartItemInCart(cart, cartItem, quantity);
        }
        
        public static CartItem getCartItemByIdInCart(Cart cart,int pId){
        	return CartService.getCartItemByIdInCart(cart, pId);
        }
        
        public static List<CartItem> getAllCartItemFromCart(Cart cart){
        	return CartService.getAllCartItemFromCart(cart);
        }
}
