package dao;

import java.util.List;

import modal.StockItem;
import DB.StockData;
import Enum.Status;

public class StockDaoImpl implements StockDao{

	@Override
	public Status updateStock(List<StockItem> stockItems) {
		return StockData.updateStock(stockItems);
	}

}
