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
	
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Users> userData(@PathVariable String username, String password) {
		password = "GOGOL";
		Users user = loginService.login(username, password);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	  
	
	
	//@PostMapping
	
	//@GetMapping
	
	
	//Profile, Employee, Store, Login

}
