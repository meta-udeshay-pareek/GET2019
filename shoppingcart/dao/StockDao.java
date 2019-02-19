package dao;

import java.util.List;

import Enum.Status;
import modal.StockItem;

public interface StockDao {
	public List<StockItem> getAllItem();
	public StockItem getItemById(int id);
	public Status addItem(StockItem stockItem);
	public Status deleteItem(StockItem stockItem);
}
