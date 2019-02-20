package modal;

public class CartItem {
	
	private Product product;
	private int quantity;
	private int pk;//primary key
	private int cartId;//in which cart this cartItem is going to be added
	
	private static int id=1;//for generation of unique primary key 
	
	public CartItem() {
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
	
	
	
	/*
	 * @return cartId  in which cart this cartItem exist
	 * */
	public int getCartId() {
		return cartId;
	}

	/*
	 * @param cartId i.e. in which cart this cartItem is going to be added
	 * */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	/////////////////////////////////////////////
	 /*
     * @return id unique id for each user
     * */
    private static int genrateUniqueId(){
    	return id++;//static instance variable
    }
	
}
