package dao;

import java.util.List;

import modal.StockItem;
import Enum.Status;


public interface StockDao {
	public Status updateStock(List<StockItem> stockItems);
}
