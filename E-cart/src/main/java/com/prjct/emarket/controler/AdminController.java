package com.prjct.emarket.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prjct.emarket.dto.Payment;
import com.prjct.emarket.helper.Login;
import com.prjct.emarket.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String gotoLogin(ModelMap map)
	{  
		return "AdminLogin";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Login login, ModelMap map,HttpSession session)
	{
	return adminService.Login(login, map,session);
    }
	@GetMapping("/product-approve")
	public String ViewAllproducts(HttpSession session ,ModelMap model)
	{
	if(session.getAttribute("admin")==null)
	{
		model.put("fail", "something went wrong");
		
		return "AdminLogin";
	}
	else
	{
	return adminService.fetchAllProducts(model);
}
	}
	@GetMapping("/product-changestatus/{id}")
	public String changeStatus(@PathVariable int id,ModelMap model, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.changeStatus(model,id);
		}
	}
	@GetMapping("/merchant-approve")
	public String approvemerchant(HttpSession session,ModelMap map) {
		if(session.getAttribute("admin")==null)
		{
			map.put("fail","Session Expired Login Again");
			return "AdminLogin";
		}else{
		
			return adminService.approvemerchant(map);
		}
	}
	
	@GetMapping("/customer-view")
	public String viewCustomers(ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.viewCustomers(model);
		}
	}
	@GetMapping("/payment-add")
	public String loadAddPaymentPage(ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return "AddPaymentOption";
		}
	}
	@PostMapping("/payment-add")
	public String addPaymentPage(Payment payment,ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.addPaymentPage(payment,model);
		}
	}
	
}