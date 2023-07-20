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
import com.prjct.emarket.dto.Wishlist;
import com.prjct.emarket.helper.Login;
import com.prjct.emarket.service.CustomerService;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
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
		@GetMapping("/products-view")
		public String viewstatus(ModelMap model,HttpSession session)
		{
			return service.fetchproducts(model,session);
		}
		@GetMapping("/cart-add/{id}")
		public String addToCart(ModelMap model,HttpSession session,@PathVariable int id)
		{
			return service.addToCart(model,session,id);
		}
		
		@GetMapping("/cart-view")
		public String viewCart(ModelMap model,HttpSession session)
		{
			return service.viewCart(model,session);
		}
		@GetMapping("/cart-remove/{id}")
		public String removeFromCart(HttpSession session,ModelMap model,@PathVariable int id)
		{
			return service.removeFromCart(session,model,id);
		}
		@GetMapping("/wishlist-add/{id}")
		public String addToWishlist(ModelMap model,HttpSession session,@PathVariable int id)
		{
			return service.loadWishlist(model,session,id);
		}
		
		@GetMapping("/wishlist-create/{id}")
		public String gotoWishlist(ModelMap model,HttpSession session,@PathVariable int id)
		{
			return service.gotoWishlist(model,session,id);
		}
		

		@PostMapping("/wishlist-create/{id}")
		public String createWishlist(ModelMap model,HttpSession session,@PathVariable int id,@RequestParam String name)
		{
			return service.createWishlist(model,session,id,name);
		}
		
		@GetMapping("/wishlist-view")
		public String viewWishlist(ModelMap model,HttpSession session)
		{
			return service.viewWishlist(model,session);
		}
		
		@GetMapping("/wishlist/product-view/{id}")
		public String viewWishlistProducts(@PathVariable int id,ModelMap model,HttpSession session)
		{
			return service.viewWishlistProducts(id,model,session);
		}
		@GetMapping("/wishlist-add/{wid}/{pid}")
		public String addToWishList(@PathVariable int wid,@PathVariable int pid, ModelMap model, HttpSession session)
		{
			return service.addToWishList(model, session, wid,pid);
		}
		
		@GetMapping("/wishlist-remove/{wid}/{pid}")
		public String removeFromWishList(@PathVariable int wid,@PathVariable int pid, ModelMap model, HttpSession session)
		{
			return service.removeFromWishList(model, session, wid,pid);
		}

		@GetMapping("/wishlist-delete/{wid}")
		public String removeWishList(@PathVariable int wid, ModelMap model, HttpSession session)
		{
			return service.removeWishList(model, session, wid);
		}



}
