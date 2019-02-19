package factory;


import modal.Product;
import modal.StockItem;

public class StockItemFactory {

	/*
	 * @param product
	 * @return Object of StockItem
	 *  */
	public static StockItem getCartItemInstance(Product product,int quantity){
		StockItem stockItem= new StockItem();
		stockItem.setProduct(product);
		stockItem.setQuantity(quantity);
		
		return stockItem;
	}
}
