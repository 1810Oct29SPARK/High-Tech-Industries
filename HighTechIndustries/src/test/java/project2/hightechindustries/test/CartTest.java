package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.CartDAOImpl;

class CartTest {
	
	CartDAO cd = new CartDAOImpl();

	@Test
	public void getAllCartItemsById() {
		
		Cart c = new Cart();
		c.setCartId(24);
		c.setMemberId(2);
		c.setProductId(2);
		c.setQuantity(10);
		
		Assert.assertEquals(c.toString(), cd.getAllCartItemsById(2).get(0).toString());
		
	}
	
//	@Test
//	public void addOrUpdateCartItem() {
//		
//		Cart newC = new Cart();
//		newC.setCartId(44);
//		newC.setMemberId(5);
//		newC.setProductId(9);
//		newC.setQuantity(40);
//		
////		cd.addOrUpdateCartItem(new Cart(5, 9, 20));
//		
//		Assert.assertEquals(newC.toString(), cd.getAllCartItemsById(5).get(0).toString());
//		
//	}
	
	@Test
	public void deleteCartItem() {
		
//		cd.deleteCartItem(cd.getAllCartItemsById(5).get(0));
		
		Assert.assertEquals(0, cd.getAllCartItemsById(5).size());
		
	}

}
