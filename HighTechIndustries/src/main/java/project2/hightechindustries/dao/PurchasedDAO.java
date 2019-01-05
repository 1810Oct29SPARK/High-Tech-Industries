package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Purchased;

public interface PurchasedDAO {
	
	public Purchased getPurchasedItemById(int id);
	public List<Purchased> getAllPurchased();
	public void addPurchased(Purchased p);
//	public void updatePurchased(Purchased p);
	public void deletePurchased(Purchased p);

}
