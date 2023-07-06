package com.prjct.emarket.controler;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.service.MerchantService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/merchant")
public class MerchantController 
{
	@Autowired
	MerchantService merchantService;
	
	@GetMapping("/login")
	public String gotoLogin(ModelMap map)
	{  
		return "MerchantLogin";
	}
	@GetMapping("/signup")
	public String gotoSignup()
	{
		return "MerchantSignup";
			
	}
	@GetMapping("/forgotpassword")
	public String gotoForgotPassword()
	{
	return "MerchantForgotPassword";	
	}
	@PostMapping("/signup")
	public String signup(ModelMap model,Merchant merchant,@RequestParam String date,@RequestParam MultipartFile pic) throws IOException
	{
		return merchantService.signup(model,merchant,date,pic);
	}
	@PostMapping("/verify-otp/{email}")
	public String verifyOtp(@PathVariable String email,@RequestParam int otp,ModelMap model)
	{
		return merchantService.verifyOtp(email,otp,model);
	}
	
	@GetMapping("/resend-otp/{email}")
	public String resendOtp(@PathVariable String email,ModelMap model)
	{
		return merchantService.resendOtp(email,model);
		
	}
	@PostMapping("/forgotpassword")
	public String sendForgotPassword(@RequestParam  String email, ModelMap model)
	{
		return  merchantService.sendForgotPass(email, model);
	}
	@PostMapping("/forgot-otp/{email}")
	public String forgototp(@PathVariable String email,@RequestParam int otp,ModelMap model)
	{
		return merchantService.verifyforgotpassotp(email,otp,model);
	}
	@GetMapping("/resend-forgot-otp/{email}")
	public String resendforgotOtp(@PathVariable String email,ModelMap model)
	{
		return merchantService.resendforgotOtp(email,model);
		
	}
	@PostMapping("/ResetPassword")
	public String setPaasword(@RequestParam String email, @RequestParam String password ,ModelMap model )
	{
		return merchantService.setPassword(email,password,model);
	}
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password ,ModelMap model,HttpSession session)
	{
	 return merchantService.loginMerchant(email,password,model,session);
	}
	
	
}
