package dao;

import java.util.List;
import modal.Product;
import modal.StockItem;
import Enum.Status;

public interface StockItemDao{
	public StockItem getStockItemById(int id);
	public Status saveStockItem(StockItem stockItem);
	public Status deleteStockItem(int index);
	public List<StockItem> getAllStockItem();
	public Status updateStockItem(StockItem stockItem,Product product,int quantity);
}
