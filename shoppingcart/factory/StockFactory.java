package factory;

import modal.Stock;

public class StockFactory {

	/*
	 * @return stock  instance of Stock class
	 * */
	public static Stock getStockInstance(){
		//as Stock is singleton class so we have to get it instance from method
		return Stock.getInstance();
	}
}
