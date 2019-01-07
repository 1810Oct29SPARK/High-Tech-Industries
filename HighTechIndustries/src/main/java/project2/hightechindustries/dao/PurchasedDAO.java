package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Purchased;

public interface PurchasedDAO {
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can see all of the instances of a certain product sold and who bought them.
	 * This could be useful for employees who want to see how well certain products are selling.
	 *   It could also come in handy in case of a recall; employees in charge of recalled item can find how 
	 *   many have been sold and to whom.
	 */
	public List<Purchased> getPurchasedItemsByProductId(int productId);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can view a history of what items they purchased.
	 */
	public List<Purchased> getPurchasedItemsByMemberId(int memberId);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can view a list of all items sold in the company's history
	 * This can be useful after the company has been around for a while, so that they can start saying:
	 *   1,000,000 units sold and so forth
	 * Also, this could be useful for the company to be able have a side-by-side comparison of their best-
	 *   selling products and their worst-selling products
	 * This way they could know what they need to improve, what should be upgraded, etc.
	 */
	public List<Purchased> getAllPurchased();
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can buy products from their cart
	 *   (Thus adding them to the Purchased list)
	 */
	public void addPurchased(Purchased p);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that when members buy an item or return an item,
	 *   the corresponding quantity will be adjusted accordingly.
	 */
//	public void updatePurchased(Purchased p);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can return or sell back items.
	 */
	public void deletePurchased(Purchased p);

}
