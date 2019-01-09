package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Cart;

public interface CartDAO {
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can get a list of the items in their cart.
	 */
	public List<Cart> getAllCartItemsById(int memberId);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can add items to their cart.
	 * Or, if they've already bought that item before, it will increase the quantity associated with
	 *  that item by one.
	 */
	public void addOrUpdateCartItem(Cart c);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can remove items from their cart.
	 */
	public void deleteCartItem(Cart c);

}
