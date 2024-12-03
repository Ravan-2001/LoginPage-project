package com.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginPage {

	@GetMapping("/")
	public String openloginpage() {
		return "Loginpage";
	}
	
	@PostMapping("/login")
	public String showhomepage(@RequestParam("UserName")String username,
			@RequestParam("PassWord")String password,Model model) {
	boolean oneletter=false;
	boolean onedigit=false;
	for (char c : password.toCharArray()) {
		if(Character.isLetter(c)) {
			oneletter=true;
		}
		else if(Character.isDigit(c)) {
			onedigit=true;
		}
	}
	if(password.length()>=8 && oneletter && onedigit) {
		return "Homepage";
	}
	else {
		model.addAttribute("error", "password must contain mix of Letters and Digits");
		return "Loginpage";
	}
		
	}
	@GetMapping("/logout")
	public String logout() {
		return "LoginPage";
	}
}
