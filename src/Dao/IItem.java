package Dao;

import java.util.List;

import Model.Item;
import Model.OfferItems;

public interface IItem {
	
	
	
	public void addItem(Item i);
	
	
	public List<Item> getListItems() throws Exception;
	
	
	public OfferItems getItemInfoById(int itemId) throws Exception;

}
