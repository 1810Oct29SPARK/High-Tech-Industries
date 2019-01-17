package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.Test;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.CartDAOImpl;

public class CartTest {
	
	CartDAO cd = new CartDAOImpl();

//	@Test
//	public void getAllCartItemsById() {
//		
//		Cart c1 = new Cart();
//		c1.setCartId(155);
//		c1.setMemberId(138);
//		c1.setProductId(53);
//		c1.setQuantity(25);
//		
//		Cart c2 = new Cart();
//		c2.setCartId(143);
//		c2.setMemberId(138);
//		c2.setProductId(43);
//		c2.setQuantity(25);
//		
//		Assert.assertEquals(c1.toString(), cd.getAllCartItemsById(138).get(0).toString());
//		Assert.assertEquals(c2.toString(), cd.getAllCartItemsById(138).get(1).toString());
//		
//	}
	
//	@Test
//	public void addOrUpdateCartItem() {
//		
//		cd.addOrUpdateCartItem(new Cart(138, 53, 25));
//		
//		Cart newC = new Cart();
//		newC.setCartId(196);
//		newC.setMemberId(138);
//		newC.setProductId(53);
//		newC.setQuantity(75);
//		
//		Assert.assertEquals(newC.toString(), cd.getAllCartItemsById(138).get(0).toString());
//		
//	}
	
//	@Test
//	public void deleteCartItem() {
//		
//		cd.deleteCartItem(cd.getAllCartItemsById(138).get(0));
//		
//		Assert.assertEquals(0, cd.getAllCartItemsById(138).size());
//		
//	}

}
