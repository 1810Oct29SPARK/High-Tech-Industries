package project2.hightechindustries.main;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.StoreDAO;
import project2.hightechindustries.dao.StoreDAOImpl;

public class Driver {
	public static void main(String[] args) {
		Store store = new Store(21);
		StoreDAO dao = new StoreDAOImpl();
		dao.insertPhoto(21);
		
	}

}
