package controller;

import java.util.List;

import Enum.Status;
import facade.StockService;
import modal.StockItem;

public class StockController {
	
	/*
	 * @return list of all stock item
	 * */
	public static List<StockItem> getAllStockItem(){
		//calling fasade/service
		return StockService.getAllStockItem();
	}

	/*
	 * @param stockItem for adding item in stock
	 * @return status of adding item
	 * */
	public static Status addItemInStock(StockItem stockItem){
		//calling facade/service addItem
		return StockService.addItem(stockItem);
	}
	
	/*
	 * @param stockItem for adding item in stock
	 * @return status of adding item
	 * */
	public static Status deleteStockItem(StockItem stockItem){
		//calling facade/service addItem
		return StockService.deleteItem(stockItem);
	}
	
	
	public static StockItem getStockItemById(int id){
		//calling facade/service getStockItemById
		return StockService.getItemById(id);
	}
	
	public static Status updateStockItem(StockItem stockItem,int quantity){
		return StockService.updatedItem(stockItem, quantity);
	}
}
