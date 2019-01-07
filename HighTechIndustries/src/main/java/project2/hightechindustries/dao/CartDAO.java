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
	 */
	public void addCartItem(Cart c);
	
	/**
	 * @author (name-Sean)
	 * This method is here so that when members add an item to their cart,
	 *   the quantity associated with that memberId and productId will increase by the number of items added.
	 * Likewise the quantity will decrease by the number deleted when a member removes a number of items from his cart.
	 */
	public void updateCart(Cart c);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that members can remove items from their cart.
	 */
	public void deleteItem(Cart c);

}
