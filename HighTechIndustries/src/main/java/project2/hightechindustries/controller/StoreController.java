package project2.hightechindustries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.StoreDAO;

@RestController
@RequestMapping(value="/store")
public class StoreController {
	
	/**
	 * The Store Controller brings in reference variables for RecentlyViewedDAO, StoreDAO, and CartDAO.
	 * We also map methods for use in the front end that allow members to view a list of their recently
	 *  viewed items, pull up information for an individual product, view items in their cart, and view
	 *  a list of all the items in the store.
	 */
	
	@Autowired
	private RecentlyViewedDAO recentlyViewed;
	
	@Autowired
	private StoreDAO stores;
	
	@Autowired
	private CartDAO cart;
	
	@GetMapping(value="/{memberId}")
	public ResponseEntity<RecentlyViewed> getStoreItemsByMemberId(@PathVariable int memberId) {
		List<RecentlyViewed> rv = recentlyViewed.getAllRecentlyViewed(memberId);
		if (rv == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(rv.get(0), HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/item{productId}")
	public ResponseEntity<Store> getStoreItemsByProductId(@PathVariable int productId) {
		Store storeItem = stores.getStoreById(productId);
		if (storeItem == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(storeItem, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/products")
	public ResponseEntity<List<Store>> getListOfProducts() {
		List<Store> items = stores.getAllStore();
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Store>>(items, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/cart{memberId}")
	public ResponseEntity<List<Cart>> getItemsInCart(@PathVariable int memberId) {
		List<Cart> items = cart.getAllCartItemsById(memberId);
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Cart>>(items, HttpStatus.OK);
		}
	}

}