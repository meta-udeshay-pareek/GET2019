package modal;

public class StockItem {
	
	private Product product;
	private int quantity;
	private int pk;//primary key
	
	private static int id=1;//for generation of unique primary key 
	
	public StockItem() {
		this.pk = genrateUniqueId();
	}
	
	/*
	 * @return id cartItemid
	 * */
	public int getId() {
		return pk;
	}
	
	/*
	 * @return product i.e. cartItem
	 * */
	public Product getProduct() {
		return this.product;
	}
	
	/*
	 * @param product
	 * */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/*
	 * @return quantity  product quantity
	 * */
	public int getQuantity() {
		return this.quantity;
	}
	
	/*
	 * @param quantity i.e. product quantity
	 * */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	/////////////////////////////////////////////
	/*
	* @return id unique id for each user
	* */
	private static int genrateUniqueId(){
		return id++;//static instance variable
	}
}
