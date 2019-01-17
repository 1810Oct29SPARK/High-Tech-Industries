package project2.hightechindustries.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.beans.Purchased;
import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.beans.Store;
import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.PurchasedDAO;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.StoreDAO;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	private RecentlyViewedDAO recentlyViewed;

	@Autowired
	private StoreDAO stores;

	@Autowired
	private CartDAO cart;

	@Autowired
	private PurchasedDAO purchased;

	@GetMapping(value = "/{memberId}")
	public ResponseEntity<RecentlyViewed> getStoreItemsByMemberId(@PathVariable int memberId) {
		List<RecentlyViewed> rv = recentlyViewed.getAllRecentlyViewed(memberId);
		if (rv == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(rv.get(0), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/item{productId}")
	public ResponseEntity<Store> getStoreItemsByProductId(@PathVariable int productId) {
		Store storeItem = stores.getStoreById(productId);
		if (storeItem == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(storeItem, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<Store>> getListOfProducts() {
		List<Store> items = stores.getAllStore();
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Store>>(items, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/cart{memberId}")
	public ResponseEntity<List<Cart>> getItemsInCart(@PathVariable int memberId) {
		List<Cart> items = cart.getAllCartItemsById(memberId);
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Cart>>(items, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/purchased")
	public ResponseEntity<List<Purchased>> getAllPurchasedItems() {
		List<Purchased> items = purchased.getAllPurchased();
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Purchased>>(items, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/recentlyViewed/{memberId}/{productId}")
	public ResponseEntity<Store> addToRecentlyViewed(@PathVariable int memberId, @PathVariable int productId) {
		RecentlyViewed r = new RecentlyViewed(memberId, productId);
		recentlyViewed.addRecentlyViewed(r);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping(value = "/addCart/{memberId}/{productId}")
	public ResponseEntity<Cart> addToCart(@PathVariable int memberId, @PathVariable int productId) {
		Cart c = new Cart(memberId, productId, 1);
		cart.addOrUpdateCartItem(c);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping(value = "/purchase{memberId}")
	public ResponseEntity<Users> addingUser(@PathVariable int memberId) {
		List<Cart> currentCart = cart.getAllCartItemsById(memberId);
		List<Purchased> toBuy = new ArrayList<>();
		for (int x = 0; x < currentCart.size(); x++) {
			toBuy.add(new Purchased(currentCart.get(x).getMemberId(), currentCart.get(x).getProductId(),
					currentCart.get(x).getQuantity()));
			purchased.addOrUpdatePurchasedItem(toBuy.get(x));
			cart.deleteCartItem(currentCart.get(x));
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}