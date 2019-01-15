package project2.hightechindustries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.service.LoginService;

//	Jeremy

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Users> userData(@RequestParam String username, @RequestParam String password, RedirectAttributes flash) {
		Users user = loginService.login(username, password);
		if (user != null) {
			flash.addFlashAttribute("User", user);
			return new ResponseEntity<>(user, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Users> addingUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String phone, @RequestParam String employeeStatus,
			@RequestParam String username, @RequestParam String password) {
		loginService.addUserService(firstName, lastName, email, phone, employeeStatus, username, password);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Users> updatePassword(@RequestParam int userId, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String phone, @RequestParam String employeeStatus,
			@RequestParam String username, @RequestParam String password){
		try {
			loginService.updatePass(userId, firstName, lastName, email, phone, employeeStatus, username, password);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
