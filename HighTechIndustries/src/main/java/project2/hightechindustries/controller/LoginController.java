package project2.hightechindustries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.service.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Users> userData(@RequestBody String username, String password) {
		Users user = loginService.login(username, password);
		System.out.println(user);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	  
	@RequestMapping(value="/newU", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Users> addingUser(@RequestBody String firstName, String lastName, String email, String phone, String employeeStatus,
			String username, String password){
		System.out.println(firstName);
		loginService.addUserService(firstName, lastName, email, phone, employeeStatus, username, password);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	//@PostMapping
	
	//@GetMapping
	
	
	//Profile, Employee, Store, Login

}
