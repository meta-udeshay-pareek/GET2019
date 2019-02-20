package DB;

import java.util.List;

import modal.Stock;
import modal.StockItem;
import Enum.Status;

public class StockData {

	/*
	 * @param stockItems , list of stock items
	 * @return  Status.SUCCESS
	 * */
	public static Status updateStock(List<StockItem> stockItems){
		Stock.getInstance().setItemList(stockItems);//Stock is singleton class that's why thus method is providing object of that class 
		return Status.SUCCESS;
	}
}
