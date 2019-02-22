package DB;

import java.util.ArrayList;
import java.util.List;

import modal.Product;
import modal.StockItem;
import Enum.Status;

public class StockItemData {
	
	List<StockItem> stockItemList;//all StockItem will store here
	
	private static StockItemData stockItemData;//Reference variable of this class
	
	public StockItemData(){
		stockItemList = new ArrayList<StockItem>();
	}
	
	
	/*
	 * @return stockItemData instance of this class
	 * */
	
	public static StockItemData getInstance(){
		
		if(stockItemData==null){
			stockItemData= new StockItemData();
		}
		
		return stockItemData;
	}
	
	
	
	
	/*
	 * @param stockItem for saving stockItem in list
	 * @return Status , the status of adding stockItem in list
	 * */
	public Status saveStockItem(StockItem stockItem){
		this.stockItemList.add(stockItem);//adding stockItem into list
		return Status.SUCCESS;
	}
	
	/*
	 * @param index the index of stockItem in stockItemlist which we need to delete
	 * @return Status , the status of deleting a stockItem from list
	 * */
	public Status deleteStockItem(int index){
		this.stockItemList.remove(index);//deleting stockItem from list by index of stockItem
		return Status.SUCCESS;
	}
	
	/*
	 *  @return stockItemList , all the StockItem stored in list
	 *  */
	public List<StockItem> getAllStockItem(){
		return this.stockItemList;
	}
	
	
	/*
	 * @param stockItem,in which stockItem we need to do updation
	 * @param product,product updation in stockItem
	 * @param quantity , updation of quantity of product in stockItem
	 * 
	 * @return Status.Success
	 * */
	public Status updateStockItem(StockItem stockItem,Product product,int quantity){
		stockItem.setProduct(product);
		stockItem.setQuantity(quantity);
		
		return Status.SUCCESS;
	}
}
