package iCart;

class ShopingCart{
	Cart cartobj = new Cart();
	/**
	 * create the bill of items present in our cart
	 */
	public void billingCartItems()
	{
		double bill = 0;
		
		Iterator itr = cartobj.cartItemsList.iterator();
		while(itr.hasNext()){
			Item i = (Item)itr.next();
			bill += i.getPrice() * i.getQuantity();
		}
		System.out.println("Final bill for following items : ");
		showCartItems();
		System.out.println("\nTotal bill : "+ bill + "Rupees");
		System.exit(0);
	}
	/**
	 * showing the list of cart item that we add
	 */
	public void showCartItems() {
		if(cartobj.cartItemsList.isEmpty()) {
			System.out.println("\nCart is Empty");
		}
		else {
			System.out.println("\nCart Items given with their price are :");
			System.out.println("Product\tPrice\tQuantity");
			Iterator itr = cartobj.cartItemsList.iterator();
			while(itr.hasNext()) {
				System.out.println(((Item)(itr.next())).showCartValues());
			}
		}
	}
	/**
	 * we can update our quantity 
	 */
	public void updateCartItem() {
		
		if(cartobj.cartItemsList.isEmpty()) {
			
			System.out.println("Cart is already Empty");
		}
		else {
		
			String itemName;
			int quant;
			System.out.println("Enter item name to change its quantity : ");
			itemName = cartobj.sc.next();
			
			if(checkIfPresentInCart(itemName)) {
					
				 
					System.out.println("Set quantity to : ");
					quant = cartobj.sc.nextInt();
					
					cartobj.item.setQuantityBy(quant);
				
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	/**
	 * add item in our cart
	 */
	public void addCartItem() {
		
		String itemName;
		System.out.println("Enter item name to add it to cart : ");
		itemName = cartobj.sc.next();
		
		if(checkIfPresent(itemName)) {
				if(cartobj.cartItemsList.contains(cartobj.item)) {
					cartobj.item.updateQuantity(1);
				}
				else
				{
					cartobj.cartItemsList.add(cartobj.item);
					cartobj.item.updateQuantity(1);
				}
			}
		else {
			System.out.println("No product with such name.");
		}
	}
	/**
	 * remove our item from cart
	 */
	public void removeCartItem() {
		
		if(cartobj.cartItemsList.isEmpty()) {
			
			System.out.println("Cart is already Empty");
		}
		else {
		
			String itemName;
			System.out.println("Enter item name to remove it from cart : ");
			itemName = cartobj.sc.next();
		
			if(checkIfPresentInCart(itemName)) {			
					cartobj.cartItemsList.remove(cartobj.item);
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	/**
	 * show the list of all item present in our shop
	 */
	public void showAllItems() {
		
		System.out.println("\nItems present on our site with the prices are :");
		
		
		System.out.println("Product\tPrice");
		
		Iterator itr = cartobj.allItemsList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	/**
	 * check the item present in our cart list
	 * @param name of item which we want to check
	 * @return if present give true else false
	 */
	public Boolean checkIfPresentInCart(String name) {
		
		Iterator itr = cartobj.cartItemsList.iterator();
		while(itr.hasNext()) {
			cartobj.item = (Item)itr.next();
			
			if(cartobj.item.getItemName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * check the item present in our shop list
	 * @param name of item which we want to check
	 * @return if present give true else false
	 */
	public Boolean checkIfPresent(String name) {
		
		Iterator itr = cartobj.allItemsList.iterator();
		while(itr.hasNext()) {
			cartobj.item = (Item)itr.next();
			
			if(cartobj.item.getItemName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
}
