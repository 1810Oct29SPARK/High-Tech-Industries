package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project2.hightechindustries.beans.Purchased;
import project2.hightechindustries.dao.PurchasedDAO;
import project2.hightechindustries.dao.PurchasedDAOImpl;

public class PurchasedTest {
	
	PurchasedDAO p = new PurchasedDAOImpl();
	
	/**
	 * @author Esteban
	 * 
	 */
	@Test
	public void getPurchasedItemsByProductId() {
		
		Purchased purchase = new Purchased();
		purchase.setMemberId(5);
		purchase.setProductId(4);
		purchase.setQuantity(1);
		
		Assert.assertEquals(purchase.toString(), p.getPurchasedItemsByProductId(4).get(0).toString());
		
	}
	
	@Test
	public void getPurchasedItemsByMemberId() {
		
		Purchased purchase = new Purchased();
		purchase.setMemberId(5);
		purchase.setProductId(4);
		purchase.setQuantity(1);
		Assert.assertEquals(purchase.toString(), p.getPurchasedItemsByMemberId(5).get(0).toString());
		
	}
	
	@Test
	public void getAllPurchased() {
		
		Purchased purchase1 = new Purchased();
		purchase1.setMemberId(2);
		purchase1.setProductId(3);
		purchase1.setQuantity(2);
		
		Purchased purchase2 = new Purchased();
		purchase2.setMemberId(5);
		purchase2.setProductId(4);
		purchase2.setQuantity(1);
		
		Purchased purchase3 = new Purchased();
		purchase3.setMemberId(3);
		purchase3.setProductId(1);
		purchase3.setQuantity(11);
		
		Purchased purchase4 = new Purchased();
		purchase4.setMemberId(1);
		purchase4.setProductId(6);
		purchase4.setQuantity(10);
		
		Purchased purchase5 = new Purchased();
		purchase5.setMemberId(1);
		purchase5.setProductId(3);
		purchase5.setQuantity(13);
		
		Assert.assertEquals(purchase1.toString(), p.getAllPurchased().get(0).toString());
		Assert.assertEquals(purchase2.toString(), p.getAllPurchased().get(1).toString());
		Assert.assertEquals(purchase3.toString(), p.getAllPurchased().get(2).toString());
		Assert.assertEquals(purchase4.toString(), p.getAllPurchased().get(3).toString());
		Assert.assertEquals(purchase5.toString(), p.getAllPurchased().get(4).toString());
		
	}
	
	@Test
	public void addOrUpdatePurchasedItem() {
		
//		p.addOrUpdatePurchasedItem(new Purchased(5, 10, 69));
		Purchased newP1 = new Purchased();
		newP1.setMemberId(5);
		newP1.setProductId(4);
		newP1.setQuantity(1);
		
		Purchased newP2 = new Purchased();
		newP2.setMemberId(5);
		newP2.setProductId(10);
		newP2.setQuantity(69);
		
		Assert.assertEquals(newP1.toString(), p.getPurchasedItemsByMemberId(5).get(0).toString());
		Assert.assertEquals(newP2.toString(), p.getPurchasedItemsByMemberId(5).get(1).toString());
		
	}
	
	@Test
	public void deletePurchased() {
		
		p.deletePurchased(new Purchased(5, 10, 69));
		
		Assert.assertNull(p.getPurchasedItemsByMemberId(5).get(1));
		
	}

}
