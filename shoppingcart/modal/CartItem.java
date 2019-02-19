package modal;

public class CartItem {
	
	private Product product;
	private int quantity;
	private int id;
	
	
	
	public CartItem() {
		this.id = this.product.getId();//cartItemid and product id is same
	}
	
	/*
	 * @return id cartItemid
	 * */
	public int getId() {
		return id;
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
	
	
}
