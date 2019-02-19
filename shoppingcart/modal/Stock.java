package modal;

import java.util.ArrayList;
import java.util.List;

import modal.StockItem;

//this class will be singleton
public class Stock {
	
	private static Stock stock;//reference of this class
	
	private List<StockItem> stockItems;//Item in stock
	
	//this class is singleton that's why this constructor is private
	private Stock(){
		this.stockItems = new ArrayList<StockItem>();
	}
	
	/*
	 * @return stock instance of this class
	 * */
	
	public static Stock getInstance(){
		
		if(stock==null){
			stock= new Stock();
		}
		
		return stock;
	}
	
	
 
    /*
   	 * @return cartItems list of Item added in cart 
   	 * */
    public List<StockItem> getItemList() {
        return this.stockItems;
    }
    
   
    
    /*
   	 * @param Item 
   	 * */
    public void addItem(StockItem stockItem){
    	this.stockItems.add(stockItem);
    }
    
    /*
   	 * @param index of item in item list 
   	 * */
    public void deleteItem(int index){
    	this.stockItems.remove(index);
    }
}
