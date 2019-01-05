package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Cart;

public interface CartDAO {
	
	public Cart getCartById(int id);
	public List<Cart> getAllCartItems();
	public void addCartItem(Cart c);
	public void updateCart(Cart c);
	public void deleteItem(Cart c);

}
