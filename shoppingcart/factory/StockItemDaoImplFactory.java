package factory;


import dao.StockItemDaoImpl;



public class StockItemDaoImplFactory {

	public static StockItemDaoImpl getStockItemDaoImplInstance(){
		return new StockItemDaoImpl();
	}
}
