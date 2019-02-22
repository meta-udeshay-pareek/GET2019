package modal;

public class Product {
	
	private int pk;//primary key
	private String name;
	private double price;
	private String type;
	private static int id=1;//instance variable for generation unique id
	
	public Product(){
		this.pk = genrateUniqueId();
	}
	
	/*
	 * @return product Id
	 * */
	public int getId(){
		return this.pk;
	}
	

	/*
	 * @return product Name
	 * */
	public String getName(){
		return this.name;
	}
	
	/*
	 * @return product Price
	 * */
	public double getPrice(){
		return this.price;
	}
	
	/*
	 * @return product type
	 * */
	public String getType() {
		return type;
	}
	
	/*
	 * @param type product type
	 * */
	public void setType(String type) {
		this.type = type;
	}
	
	/*
	 * @param pName product Name
	 * */
	public void setName(String pName){
		this.name = pName;
	}
	
	/*
	 * @param pPrice product Price
	 * */
	public void setPrice(double pPrice){
		this.price = pPrice;
	}
	
	
	/********Private Method Which Generate Unique Id for Each User and It Is calling In Constructor******/
    /*
     * @return id unique id for each user
     * */
    private static int genrateUniqueId(){
    	return id++;//static instance variable
    }
}
