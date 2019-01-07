package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Store;

public interface StoreDAO {
	
	/**
	 * @author (name=Esteban) (for Method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members can search for a particular item in the store.
	 */
	public Store getStoreById(int id);
	
	/**
	 * @author (name=Esteban) (for Method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members can view a list of all of the avialable items in the store.
	 */
	public List<Store> getAllStore();
	
	/**
	 * @author (name=Esteban) (for Method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members(in this case employees) can add products to the store.
	 */
	public void addStore(Store store);
	
	/**
	 * @author (name=Esteban) (for Method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members(in this case employees) can update products in the store.
	 *   They can change the name, the specifications, the price, etc.
	 */
	public void updateStore(Store store);
	
	/**
	 * @author (name=Esteban) (for Method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members (once again, in this case employees) can remove products from the store.
	 */
	public void deleteStore(Store store);

}
