package view;

import java.util.List;
import java.util.Scanner;

import Enum.Status;
import controller.CartController;
import controller.CustomerController;
import controller.StockController;
import facade.CartService;
import factory.Factory;
import modal.CartItem;
import modal.Customer;
import modal.Product;
import modal.StockItem;

public class Store {
	
	static Scanner input = new Scanner(System.in);
	
	public static void menu(){
		System.out.println("---------------------------------------------");
		System.out.println(" 				1.Add user");
		System.out.println(" 				2.Add product in stock(Admin)");
		System.out.println(" 				3.Show Products which are in stock");
		System.out.println(" 				4.add item to cart");
		System.out.println(" 				5.delete item from cart");
		System.out.println(" 				6.update product quantity in cartItem");
		System.out.println(" 				7.view your cart");
		System.out.println(" 				8.Exit");
		System.out.println("---------------------------------------------");
		System.out.println("				Enter your choice:");
	}
	
	public static void main(String []args){
		while(true){
			menu();
			int choice=input.nextInt();
			
			switch (choice) {
				case 1:
					addUser();
					break;
				case 2:
					addProductInStock();
					break;
				case 3:
					viewProductsInstock();
					break;
				case 4:
					addProductTocart();
					break;
				case 5:
					deleteProductfromcart();
					break;
				case 6:
					upadteCartItem();
					break;
				case 7:
					viewCart();
					break;
				case 8:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Choice");
					break;
			}
		}
	}
	
	private static void addUser(){
		System.out.print("Enter user name:-");
		String name = input.next();
		System.out.print("Enter user address:-");
		String address = input.next();
		System.out.print("Enter user email:-");
		String email = input.next();
		System.out.print("Enter user phone number:-");
		String phone = input.next();
		
        //calling controller for saving customer
		CustomerController.saveCustomer(Factory.getCustomerInstance(name, address, email, phone));
	}
	
	
	private static void addProductInStock(){
		System.out.print("Enter product name:-");
		String name = input.next();
		System.out.print("Enter product price:-");
		double price = input.nextDouble();
		System.out.print("Enter product type:-");
		String type = input.next();
		System.out.print("Enter product quantity:-");
		int quantity = input.nextInt();
		
		//calling stockController for adding item in stock
		Status status = StockController.addItemInStock(Factory.getStockItemInstance(Factory.getProductInstance(name, price, type), quantity) );
		
		System.out.print(status.name());
	}
	
	private static void viewProductsInstock(){
		System.out.println("id  name  type  price  quantity");
		//calling controller for list of StockItem
		List<StockItem> stockItems = StockController.getAllStockItem();
		for(StockItem stockItem:stockItems){
			Product product = stockItem.getProduct();
			System.out.println(stockItem.getId()+" "+product.getName()+" "+product.getType()+" "+product.getPrice()+" "+stockItem.getQuantity());
		}
	}
	
	
	private static void addProductTocart(){
		System.out.print("Enter your userId");
		int userId=input.nextInt();
		System.out.println("Enter Item id");
		int itemId = input.nextInt();
		System.out.println("Enter Product quantity");
		int quantity = input.nextInt();
		//calling controller for getting Customer object from customer id
		Customer customer = CustomerController.getCustomerById(userId);
		
		//getting StockItem by id from Stock Controller which item we have to add in cart
		StockItem stockItem = StockController.getStockItemById(itemId);
		
		//if customer exist and stockItem exist
		if(customer!=null && stockItem!=null && stockItem.getQuantity()>=quantity){
			
			int cartId=(customer.getCart().getId());//getting cartId for cartItem
			Status status= CartController.addCartItemInCart(customer.getCart(), Factory.getCartItemInstance(stockItem.getProduct(), quantity,cartId));//creating cartItem and adding that cart item into user cart
			if(status == Status.SUCCESS){
				StockController.updateStockItem(stockItem, stockItem.getQuantity()-quantity);
			}
			System.out.print(status.name());
		}else{
			if(customer==null){
				System.out.println("User Id is wrong");
			}else{
				System.out.println("Item is not in stock");
			}
		}
		
	}
	
	
	@SuppressWarnings("unused")
	private static void deleteProductfromcart(){
		System.out.print("Enter your userId");
		int userId=input.nextInt();
		System.out.println("Enter cartItem id");
		int itemId = input.nextInt();
		
		//calling controller for getting Customer object from customer id
		Customer customer = CustomerController.getCustomerById(userId);
		
		//getting cartItem by id from Cart Controller which item we have to delete
		CartItem cartItem = CartController.getCartItemByIdInCart(customer.getCart(), itemId);
		
		//if customer exist and cartItem exist
		if(customer!=null && cartItem!=null){
			
			Status status=CartController.deleteCartItemFromCart(customer.getCart(), cartItem);
			//if has sucussfully deleted then updating stockItem quantity
			if(status==Status.SUCCESS){
				//getting all the list of stock item
				List<StockItem> stockItems = StockController.getAllStockItem();
				for(StockItem stockItem:stockItems){
					//if stockItem product and cart item priduct is same the setting quantity of stock
					if(stockItem.getProduct().getId()==cartItem.getProduct().getId()){
						StockController.updateStockItem(stockItem, stockItem.getQuantity()+cartItem.getQuantity());
					}
				}
			}
			
			System.out.print(status.name());
		}else{
			if(customer==null){
				System.out.println("User Id is wrong");
			}else{
				System.out.println("cartItem not exist");
			}
		}
		
	}
	
	
	public static void viewCart(){
		System.out.print("Enter your userId");
		int userId=input.nextInt();
		
		//calling controller for getting Customer object from customer id
		Customer customer = CustomerController.getCustomerById(userId);
		
		List<CartItem> cartItems = CartController.getAllCartItemFromCart(customer.getCart());
		
		System.out.println("id  name  type  price  quantity");
		
		for(CartItem cartItem:cartItems){
			Product product = cartItem.getProduct();
			System.out.println(cartItem.getId()+" "+product.getName()+" "+product.getType()+" "+product.getPrice()+" "+cartItem.getQuantity());
		}
	}
	
	
	public static void upadteCartItem(){
		System.out.print("Enter your userId");
		int userId=input.nextInt();
		System.out.println("Enter cartItem id");
		int itemId = input.nextInt();
		System.out.println("Enter  quantity");
		int quantity = input.nextInt();
		
		//calling controller for getting Customer object from customer id
		Customer customer = CustomerController.getCustomerById(userId);
		
		//getting cartItem by id from Cart Controller which item we have to update
		CartItem cartItem = CartController.getCartItemByIdInCart(customer.getCart(), itemId);
		
		//if customer exist and cartItem exist
		if(customer!=null && cartItem!=null){
			
			int oldQuantityOfCartItem = cartItem.getQuantity();//for updating stockItem quantity
		
			//updating cartItem quantity
			Status status = CartService.updateCartItemInCart(customer.getCart(), cartItem, quantity);
			
			//if has sucussfully updated then updating stockItem quantity
			if(status==Status.SUCCESS){
				//getting all the list of stock item
				List<StockItem> stockItems = StockController.getAllStockItem();
				
				for(StockItem stockItem:stockItems){
					//if stockItem product and cart item priduct is same the setting quantity of stock
					if(stockItem.getProduct().getId()==cartItem.getProduct().getId()){
						
						//adding back product quantity in stock and then retrive updated quantity
						int updatedQuantity=(stockItem.getQuantity()+oldQuantityOfCartItem)-quantity;//updated quantity os stockItem
						StockController.updateStockItem(stockItem, updatedQuantity);//updating quantity of stockItem
					}
				}
				
			}
			
			System.out.print(status.name());
		}else{
			if(customer==null){
				System.out.println("User Id is wrong");
			}else{
				System.out.println("cartItem not exist");
			}
		}
		
	}
}
