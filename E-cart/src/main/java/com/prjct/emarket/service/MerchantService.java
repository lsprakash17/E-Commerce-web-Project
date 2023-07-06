
package com.prjct.emarket.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.prjct.emarket.dao.Merchantdao;
import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.helper.SendmailMerchant;

import jakarta.servlet.http.HttpSession;

@Service
public class MerchantService {

	@Autowired
	Merchantdao merchantdao;

	@Autowired
	SendmailMerchant mail;

	public String signup(ModelMap model, Merchant merchant, String date, MultipartFile picture) throws IOException {
		merchant.setDob(LocalDate.parse(date));
		byte[] pic = new byte[picture.getInputStream().available()];
		picture.getInputStream().read(pic);
		merchant.setPicture(pic);
		if (merchantdao.findByEmail(merchant.getEmail()) != null
				|| merchantdao.findByMobile(merchant.getMobile()) != null) {
			model.put("fail", "Email or Mobile Should not be repeated");
			return "MerchantSignup";
		}

		// logic for otp
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);
		// Logic For Sending Mail

		if(mail.sendOtp(merchant))
		{
		Merchant merchant1 = merchantdao.save(merchant);
		model.put("merchant", merchant1);
		return "SignupOtp";
		}
		else
		{
			model.put("fail", "something went wtrong");
			return "MerchantSignup";
		}	
		
	}

//	public String verify(String email, int otp, ModelMap model) {
//		Merchant merchant = merchantdao.findByEmail(email);
//		if (merchant.getOtp() == otp) {
//			merchant.setStatus(true);
//			merchant.setOtp(0);
//			merchantdao.save(merchant);
//			model.put("pass", "Account Verified SuccessFully");
//			return "MerchantLogin";
//		} else {
//			model.put("fail", "Account not created otp entered invalid");
//			model.put("merchant", merchant);
//			return "SignupTtp";
//		}
//	}
	public String verifyOtp(String email, int otp, ModelMap model) {
		Merchant merchant = merchantdao.findByEmail(email);
		if (merchant.getOtp() == otp) {
			merchant.setStatus(true);
			merchant.setOtp(0);
			merchantdao.save(merchant);
			model.put("pass", "Account Verified SuccessFully");
			return "MerchantLogin";
		} else {
			model.put("fail", "Account not created otp entered invalid");
			model.put("merchant", merchant);
			return "SignupOtp";
		}
	}
	public String resendOtp(String email, ModelMap model) {
		Merchant merchant = merchantdao.findByEmail(email);
		// logic for otp
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);
		if(mail.sendOtp(merchant))
		{
		Merchant merchant1 = merchantdao.save(merchant);
		model.put("merchant", merchant1);
		return "SignupOtp";
		}
		else
		{
			model.put("fail", "something went wtrong");
			return "MerchantSignup";
		}	
			
	}

	public String sendForgotPass(String email, ModelMap model) {
	
		Merchant merchant=merchantdao.findByEmail(email);
		if(merchant==null)
		{
		  model.put("fail","Email not exist pls SignUp");
		  return "MerchantSignup";
	    }
		else
		{
			int otp = new Random().nextInt(100000, 999999);
			merchant.setOtp(otp);
			if(mail.sendOtp(merchant))
			{
			Merchant merchant1 = merchantdao.save(merchant);
			model.put("merchant", merchant1);
			model.put("pass", "Otp sent Success");
			return "ForgotPassword";
			}
			else
			{
				model.put("fail", "something went wtrong");
				return "MerchantForgotPassword";
			}	
		}


	}

	public String verifyforgotpassotp(String email, int otp, ModelMap model) {
		Merchant merchant = merchantdao.findByEmail(email);
		if (merchant.getOtp()==otp) 
		{
			merchant.setStatus(true);
			merchant.setOtp(0);
			merchantdao.save(merchant);
			model.put("merchant",merchant);
			model.put("pass", "Account Verified SuccessFully");
			return "MerchantNewPassword";
		}
		else
		{
			model.put("fail", "Incorrect OTP");
			model.put("extra", "Again");
			model.put("merchant", merchant);
			return "ForgotPassword";
		}
	}

	public String resendforgotOtp(String email, ModelMap model) {
		Merchant merchant = merchantdao.findByEmail(email);
		// logic for otp
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);
		if(mail.sendOtp(merchant))
		{
		Merchant merchant1 = merchantdao.save(merchant);
		model.put("merchant", merchant1);
		return "ForgotPassword";
		}
		else
		{
			model.put("fail", "something went wtrong");
			return "MerchantForgotPassword";
		}	
			
	}

	public String setPassword(String email, String password, ModelMap model) {
	Merchant merchant=merchantdao.findByEmail(email);
	merchant.setPassword(password);
	merchantdao.save(merchant);
	model.put("pass", "Password Reset Success");
	return "MerchantLogin";
	}

	public String loginMerchant(String email, String password ,ModelMap model,HttpSession session) {
	 Merchant merchant=merchantdao.findByEmail(email);
	 if(merchant==null)
	 {   
		 model.put("fail", "Icorrect password");
		 return "MerchantLogin";
	 }
	 else
	 {
		 if(merchant.getPassword().equals(password))
		 {
			 session.setAttribute("merchant", merchant);
			 model.put("pass", "Login Success");
			 return "MerchantHome";
		 }
		 else
		 {   
			 model.put("fail", "Icorrect password");
			 return "MerchantLogin";
		 }
	 }
	 
	}
}