package project2.hightechindustries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import project2.hightechindustries.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	public LoginController(LoginService loginService) {
		super();
	}

}
