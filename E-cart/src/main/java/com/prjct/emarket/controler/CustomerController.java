package com.prjct.emarket.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prjct.emarket.dto.Customer;
import com.prjct.emarket.helper.Login;
import com.prjct.emarket.service.CustomerService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
		@GetMapping("/login")
		public String gotoLogin()
		{  
			return "CustomerLogin";
		}
		@GetMapping("/signup")
		public String gotoSignup()
		{
			return "CustomerSignup";
				
		}
		@GetMapping("/forgotpassword")
		public String gotoForgotPassword()
		{
		return "CustomerForgotPassword";	
		}
		
		@PostMapping("/signup")
		public String Signup(Customer customer ,@RequestParam String date,ModelMap model)
		{
			return service.Signup(customer,date,model);
		}
		@GetMapping("/verifyotp/{email}/{token}")
		public String verifyotp(@PathVariable String email,@PathVariable String token,ModelMap model)
		{
			return service.verify(email,token,model);
		}
		@PostMapping("/login")
		public String login(Login login,HttpSession session,ModelMap model)
		{
			return service.login(login,session,model);
		}
		@PostMapping("/forgot-link")
		public String forgotlink(@RequestParam String email,ModelMap model)
		{
			return service.forgotlink(email,model);
		}
		@GetMapping("/Resetpasssword/{email}/{token}")
		public String ResetPassword(@PathVariable String email,@PathVariable String token,ModelMap model)
		{
			return service.ResetPassword(email,token,model);
		}
		@PostMapping("/ResetPassword")
		public String sendForgotPassword(@RequestParam String email,@RequestParam String password ,ModelMap model)
		{
			return  service.sendForgotPass(email, model,password);
		}
}
