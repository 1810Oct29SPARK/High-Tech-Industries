package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Store;

public interface StoreDAO {
	
	public Store getStoreById(int id);
	public List<Store> getAllStore();
	public void addStore(Store store);
	public void updateStore(Store store);
	public void deleteStore(Store store);

}
