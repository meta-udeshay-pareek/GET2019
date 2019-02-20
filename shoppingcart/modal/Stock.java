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
   	 * @return stockItems list of Item added in stock 
   	 * */
    public List<StockItem> getItemList() {
        return this.stockItems;
    }
    
    
    /*
   	 * @param stockItems list of stock item
   	 * */
    public void setItemList(List<StockItem> stockItems) {
        this.stockItems =stockItems;
    }
    
}
