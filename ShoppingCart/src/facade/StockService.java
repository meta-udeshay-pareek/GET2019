package facade;

import java.util.List;


import factory.StockItemDaoImplFactory;
import Enum.Status;
import modal.StockItem;

public class StockService {

	/*
	 *
	 * @param stockItem the item which you have to add in list
	 * 
	 * @return "Status.DUPLICATE" if item is already in Stock list else return "Status.SUCCESS"
	 * */
	public static  Status addItem(StockItem stockItem){
		//calling dao for getting stock item list
		List<StockItem> stockItems = StockItemDaoImplFactory.getStockItemDaoImplInstance().getAllStockItem();
		
		for(StockItem item:stockItems){
			//if item is already in cart than return Duplicate
			if(item.getId()==stockItem.getId()){
				return Status.DUPLICATE;
			}
		}
		
		//if item is not in Stock list then add item in list
		//calling Dao saveStockItem
		StockItemDaoImplFactory.getStockItemDaoImplInstance().saveStockItem(stockItem);
		
		
		
		return Status.SUCCESS;
	}
	
	
    

	/*
	 * 
     * @param stockItem the item which you have to delete from list
     * @return "Status.SUCCESS" if item is already in cartItem list else return "Status.NOT_EXIST"
     * */
    public static Status deleteItem(StockItem stockItem){
    	
    	int index=0;
    	//calling dao for getting stock item list
    	List<StockItem> stockItems = StockItemDaoImplFactory.getStockItemDaoImplInstance().getAllStockItem();
    	
    	
    	for (StockItem item : stockItems) {
    		
    		//If item found then delete it by index
            if (item.getId()==stockItem.getId()) {
            	
            	return StockItemDaoImplFactory.getStockItemDaoImplInstance().deleteStockItem(index);//deleting item by index from list
               
            }
            
            index++;//incrementing index 
        }
    	
    	return Status.NOT_EXIST;
    }
    
    
    /*
	 * @param stockItem the item which quantity you have to update in list
     *
     * @return "Status.SUCCESS" if item quantity has updated else return "Status.NOT_EXIST"
     * */
    public static Status updatedItem(StockItem stockItem,int quantity){
    	
    	//calling dao for getting stock item list
    	List<StockItem> stockItems = StockItemDaoImplFactory.getStockItemDaoImplInstance().getAllStockItem();
    	
    	
    	for (StockItem item : stockItems) {
    		//If item found then update quantity
            if (item.getId()==stockItem.getId()){
                item.setQuantity(quantity);
                return Status.SUCCESS;
            }
            
        }
    	
    	return Status.NOT_EXIST;
    }
    
    
    /*
	 * 
     * @param pId stockItem Id
     * @return stockItem stockItem which found in Stock by id 
     *     else "null" if not found in Stock
     * */
    public static StockItem getItemById(int pId) {
    	
    	//calling dao for getting stock item list
    	List<StockItem> stockItems = StockItemDaoImplFactory.getStockItemDaoImplInstance().getAllStockItem();
    	
    	for (StockItem item : stockItems) {
    		//If item found then update quantity
            if (item.getId()==pId) {
                return item;
            }
            
        }
        return null;
    }
    
    
    /*
     * @return list of item which are in stock
     * */
    public static List<StockItem> getAllStockItem(){
    	//calling Dao for All stock item list
    	return StockItemDaoImplFactory.getStockItemDaoImplInstance().getAllStockItem();    
    }
    
	
	
}
