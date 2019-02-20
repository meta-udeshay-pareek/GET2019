package view;

import java.util.List;
import java.util.Scanner;

import controller.CustomerController;
import controller.StockController;
import factory.CartItemFactory;
import factory.CustomerFactory;
import factory.ProductFactory;
import factory.StockItemFactory;
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
		System.out.println(" 				4.add product to cart");
		System.out.println(" 				5.delete product from cart");
		System.out.println(" 				6.update product quantity in cart");
		System.out.println(" 				7.view your cart");
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
				default:
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
		
		CustomerFactory.getCustomerInstance(name, address, email, phone);
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
		StockController.addItemInStock(StockItemFactory.getStockItemInstance(ProductFactory.getProductInstance(name, price, type), quantity) );
	}
	
	private static void viewProductsInstock(){
		System.out.println("id  name  type  price  quantity");
		//calling controller for list of StockItem
		List<StockItem> stockItems = StockController.getAllStockItem();
		for(StockItem stockItem:stockItems){
			Product product = stockItem.getProduct();
			System.out.println(product.getId()+" "+product.getName()+" "+product.getType()+" "+product.getPrice()+" "+stockItem.getQuantity());
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
		if(customer!=null && stockItem!=null){
			
			CartItemFactory.getCartItemInstance(stockItem.getProduct(), quantity);
		}
		
	}
}
