package iCart;
class Item {

	
	private String name;
	private int quantity;
	private double price;
	
	Item(String name,double price,int quantity){
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;	
	}
	Item(String name,double price){
		this.name = name;
		this.price = price;
	}
	
	public String showCartValues() {
		return name + "\t" + price+ "\t" + quantity;
	}
	public String toString(){
		return name + "\t" + price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void setQuantityBy(int val) {
		this.quantity = val;
	}
}
