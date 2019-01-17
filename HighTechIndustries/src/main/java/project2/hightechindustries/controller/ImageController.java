package project2.hightechindustries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.StoreDAO;

@RestController
@RequestMapping(value="/image")
public class ImageController {
	
	@Autowired
	private StoreDAO stores;
		
	@GetMapping(value="/{productId}")
	public ResponseEntity<Store> getImageByProductId(@PathVariable int productId) {
		Store productImage = stores.getStoreById(productId);
		if (productImage == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(productImage, HttpStatus.OK);
		}
	}

}
