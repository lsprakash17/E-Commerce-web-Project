package com.prjct.emarket.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.prjct.emarket.dto.Customer;
import com.prjct.emarket.dto.Merchant;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendmailMerchant {

	@Autowired
	JavaMailSender MailSender;

	public boolean sendOtp(Merchant merchant) {
		MimeMessage mimeMessage = MailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setFrom("E-Market");
			helper.setTo(merchant.getEmail());
			helper.setSubject("Veryfi Email for Account creation");

			String gender = null;
			if (merchant.getGender().equals("male"))
				gender = "Mr.";
			else
				gender = "Ms.";
			String content = "<h1>Hello " + gender + " " + merchant.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate enter the below otp to verify your account</h1>"
					+ "<h1>OTP: " + merchant.getOtp();
			helper.setText(content, true);
			MailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			return false;
		}

	}

	public boolean sendLink(Customer customer) {
		MimeMessage mimeMessage = MailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setFrom("E-Market");
			helper.setTo(customer.getEmail());
			helper.setSubject("Veryfi Email for Account creation");

			String gender = null;
			if (customer.getGender().equals("male"))
				gender = "Mr.";
			else
				gender = "Ms.";
			String link=  "http://localhost:8080/customer/verifyotp/" + customer.getEmail() +"/"+ customer.getToken();
			String content = "<h1>Hello " + gender + " " + customer.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate Click the "
					+ "below Link to verify your account</h1>" + "<h1>OTP: <a href='"+link+"'>click here</a></h1>";
			helper.setText(content, true);

			MailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			return false;
		}

	}

	public boolean sendResetLink(Customer customer) 
	{
		MimeMessage mimeMessage = MailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setFrom("E-Market");
			helper.setTo(customer.getEmail());
			helper.setSubject("Veryfi Email for Account creation");

			String gender = null;
			if (customer.getGender().equals("male"))
				gender = "Mr.";
			else
				gender = "Ms.";
			String link=  "http://localhost:8080/customer/Resetpasssword/'" + customer.getEmail() +"/"+ customer.getToken()   ;
			String content = "<h1>Hello " + gender + " " + customer.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate Click the "
					+ "below Link to verify your account</h1>" + "<h1>OTP: <a href="+link+">click here</a></h1>";
			helper.setText(content, true);

			MailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			return false;
		}	
	}
}
