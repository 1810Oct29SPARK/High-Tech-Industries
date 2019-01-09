package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.StoreDAO;
import project2.hightechindustries.dao.StoreDAOImpl;

class StoreTest {
	
	StoreDAO s = new StoreDAOImpl();

	/**
	 * @author Esteban
	 * Set the expected object of type Store and fetch data from database
	 */
	@Test
	public void getStoreItem() {
		
		Store store = new Store();
		store.setProductId(1);
		store.setProductName("Silver Jacket");
		store.setDescription("A quality piece of American Manufactured Ingenuity");
		store.setSpecs("Robot");

        Assert.assertEquals(store, s.getStoreById(1));
	}

	/**
	 * @author Esteban
	 * Get a list of all Store, have to first create an Object of Store with expected list of all Store and then
	 * evaluate whether the returned object with a list of Store is correct
	 */
	@Test
	public void listStoreItems() {
		
        Store store1 = new Store();
		store1.setProductId(1);
		store1.setProductName("Silver Jacket");
		store1.setDescription("A quality piece of American Manufactured Ingenuity");
		store1.setSpecs("Robot");

        Store store2 = new Store();
		store2.setProductId(2);
		store2.setProductName("Silver Hornet");
		store2.setDescription("A quality piece of American Manufactured Ingenuity");
		store2.setSpecs("Robot");

        Store store3 = new Store();
		store3.setProductId(3);
		store3.setProductName("Silver Wasp");
		store3.setDescription("A quality piece of American Manufactured Ingenuity");
		store3.setSpecs("Robot");

        Store store4 = new Store();
		store4.setProductId(4);
		store4.setProductName("Seismic Sensor");
		store4.setDescription("A quality piece of American Manufactured Ingenuity");
		store4.setSpecs("Sensor");

        Store store5 = new Store();
		store5.setProductId(5);
		store5.setProductName("Super Seismic Sensor");
		store5.setDescription("A quality piece of American Manufactured Ingenuity");
		store5.setSpecs("Sensor");

        Store store6 = new Store();
		store6.setProductId(6);
		store6.setProductName("Standard Sentry");
		store6.setDescription("A quality piece of American Manufactured Ingenuity");
		store6.setSpecs("Robot");

        Store store7 = new Store();
		store7.setProductId(7);
		store7.setProductName("Armed Sentry");
		store7.setDescription("A quality piece of American Manufactured Ingenuity");
		store7.setSpecs("Robot");

        Store store8 = new Store();
		store8.setProductId(8);
		store8.setProductName("Elite Sentry");
		store8.setDescription("A quality piece of American Manufactured Ingenuity");
		store8.setSpecs("Robot");

        Store store9 = new Store();
		store9.setProductId(9);
		store9.setProductName("Thermal Sensor");
		store9.setDescription("A quality piece of American Manufactured Ingenuity");
		store9.setSpecs("Sensor");

        Store store10 = new Store();
		store10.setProductId(10);
		store10.setProductName("Laser-Light Sensor");
		store10.setDescription("A quality piece of American Manufactured Ingenuity");
		store10.setSpecs("Sensor");

        Store store11 = new Store();
		store11.setProductId(11);
		store11.setProductName("K-9");
		store11.setDescription("A quality piece of American Manufactured Ingenuity");
		store11.setSpecs("Robot");

        Store store12 = new Store();
		store12.setProductId(12);
		store12.setProductName("K-10");
		store12.setDescription("A quality piece of American Manufactured Ingenuity");
		store12.setSpecs("Robot");

        Assert.assertEquals(store1, s.getAllStore().get(0));
        Assert.assertEquals(store2, s.getAllStore().get(1));
        Assert.assertEquals(store3, s.getAllStore().get(2));
        Assert.assertEquals(store4, s.getAllStore().get(3));
        Assert.assertEquals(store5, s.getAllStore().get(4));
        Assert.assertEquals(store6, s.getAllStore().get(5));
        Assert.assertEquals(store7, s.getAllStore().get(6));
        Assert.assertEquals(store8, s.getAllStore().get(7));
        Assert.assertEquals(store9, s.getAllStore().get(8));
        Assert.assertEquals(store10, s.getAllStore().get(9));
        Assert.assertEquals(store11, s.getAllStore().get(10));
        Assert.assertEquals(store12, s.getAllStore().get(11));
	}

	/**
	 * @author Esteban
	 * Get a list of all Store items, have to first create an Object of Store with expected list of all items and then
	 * evaluate whether the returned object with a list of store is correct
	 */
//	@Test
//	public void addStoreTest() {
//	
//		s.addStore(new Store("Sangvis Ferri unit", "Very basic unit that shoots everything", 500.49, "Good accuracy but weak", null));
//
//      Store store = new Store();
//		store.setProductId(22);
//		store.setProductName("Sangvis Ferri unit");
//		store.setDescription("Very basic unit that shoots everything");
//		store.setPrice(500.49);
//		store.setSpecs("Good accuracy but weak");
//	
//		Assert.assertEquals(store, s.getStoreById(22));
//	}
	
	/**
	 * @author Esteban
	 * Updates the information of an item including the product id. Need to supply every bit of information to change it.
	 */
//	@Test
//	public void updateStoreTest() {
//	
//		s.updateStore(new Store(21,"Sangvis Ferri Vespid", "Very basic unit that shoots everything", 420.69, "Good accuracy but weak", null));
//		
//		Store store = new Store();
//		store.setProductId(21);
//		store.setProductName("Sangvis Ferri Vespid");
//		store.setDescription("Very basic unit that shoots everything");
//		store.setPrice(420.69);
//		store.setSpecs("Good accuracy but weak");
//		
//		Assert.assertEquals(store, s.getStoreById(21));
//	}
	/**
	 * @author Esteban
	 * Delete an item by getting an object with the items id and then pass the object into the delete method
	 */
	@Test
	public void deleteStoreTest() {
		
		Store sto = s.getStoreById(22);
		s.deleteStore(sto);
		
		Assert.assertNull(s.getStoreById(22));
		
	}

}
