package project2.hightechindustries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project2.hightechindustries.beans.Purchased;
import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.PurchasedDAO;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

@RestController
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private UserDAO user;
	
	@Autowired
	private PurchasedDAO purchased;
	
	@GetMapping(value="/{memberId}")
	public ResponseEntity<Users> getMemberById(@PathVariable int memberId) {
		Users u = user.getUserById(memberId);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/changeInfo")
	public ResponseEntity<Users> updateMemberById(@RequestParam int memberId, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String phone,
			@RequestParam String employeeStatus, @RequestParam String username, @RequestParam String password) {
		UserDAO updateUser = new UserDAOImpl();
		updateUser.updateUser(new Users(memberId, firstName, lastName, email, phone, employeeStatus, null, null, username, password, null));
		Users u = user.getUserById(memberId);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/purchased{memberId}")
	public ResponseEntity<List<Purchased>> getPurchasedList(@PathVariable int memberId) {
		System.out.println(memberId);
		List<Purchased> items = purchased.getPurchasedItemsByMemberId(memberId);
		if (items == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Purchased>>(items, HttpStatus.OK);
		}
	}
	

}
