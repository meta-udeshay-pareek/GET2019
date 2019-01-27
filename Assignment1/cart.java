import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cart {
	static List<Object> cartItemsList;
	static List<Object> allItemsList;
	static Scanner sc = new Scanner(System.in);
	static Item item;
	/**
	 * creating the list 
	 * shop list with parameter
	 * cart list which is empty
	 */
	public void intialiseValue()
	{
		allItemsList = new ArrayList<>();
		cartItemsList = new ArrayList<>();
		
		allItemsList.add(new Item("Shoe",500));
		allItemsList.add(new Item("Shirt",300));
		allItemsList.add(new Item("Jeans",700));
		allItemsList.add(new Item("Bag",400));
		allItemsList.add(new Item("Wallet",50));
	}

	public static void main(String[] args) {
		ShopingCart shopingcart =new ShopingCart();
		Cart cartobj =new Cart();
		cartobj.intialiseValue();// intialise the shop list and cart list
		shopingcart.showAllItems();//show the shop list
		while(true){
		System.out.println(" 1.Add Item to cart \n 2.Remove Item from cart \n 3.See Items present in cart \n 4.Update cart items quantity \n 5.Billing of cart Items \n");
		System.out.println("Enter your choice : ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			shopingcart.addCartItem();
			break;
		case 2:
			shopingcart.removeCartItem();
			break;
		case 3:
			shopingcart.showCartItems();
			break;
		case 4:
			shopingcart.updateCartItem();
			break;
		case 5:
			shopingcart.billingCartItems();
			break;
		default:
			System.out.println("Wrong Input! Try Again...");
		}
	}

	}

}
