package dao;

import java.util.List;

import modal.Product;
import modal.StockItem;
import DB.StockItemData;
import Enum.Status;

public class StockItemDaoImpl implements StockItemDao{

	@Override
	public Status saveStockItem(StockItem stockItem) {
		//calling DB(database) for adding item in stockItemList
		return StockItemData.getInstance().saveStockItem(stockItem);
	}

	@Override
	public Status deleteStockItem(int index) {
		return StockItemData.getInstance().deleteStockItem(index);
	}

	@Override
	public List<StockItem> getAllStockItem() {
		//calling DB(database) for getting list
		return StockItemData.getInstance().getAllStockItem();
	}

	@Override
	public Status updateStockItem(StockItem stockItem, Product product,int quantity) {
		return StockItemData.getInstance().updateStockItem(stockItem, product, quantity);
	}

	
	
	
	
	
	@Override
	public StockItem getStockItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
