package project2.hightechindustries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.dao.RecentlyViewedDAO;

@Controller
@RequestMapping(value="/store")
public class StoreController {
	
	@Autowired
	private RecentlyViewedDAO recentlyViewed;
	
	@RequestMapping(value="/{memberId}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<RecentlyViewed> getPurchasedItemsByMemberId(@PathVariable int memberId) {
		List<RecentlyViewed> rv = recentlyViewed.getAllRecentlyViewed(memberId);
		if (rv == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(rv.get(0), HttpStatus.OK);
		}
	}

}
