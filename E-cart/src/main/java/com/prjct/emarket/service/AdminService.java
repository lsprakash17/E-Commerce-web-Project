package com.prjct.emarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.prjct.emarket.dto.Customer;
import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.dto.Payment;
import com.prjct.emarket.dto.Product;
import com.prjct.emarket.helper.Login;
import com.prjct.emarket.repository.CustomerRepository;
import com.prjct.emarket.repository.MerchantRepository;
import com.prjct.emarket.repository.ProductRepository;
import com.prjct.emarket.repository.paymentRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService
{
 
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
    MerchantRepository merchantRepository;
	
	@Autowired
	ProductRepository productsrepository;
	
	@Autowired
	paymentRepository paymentrepository;
		
	public String Login(Login login,ModelMap map,HttpSession session)
	{
		if(login.getEmail().equals("admin"))
		{
			if(login.getPassword().equals("admin"))
			{
				session.setAttribute("admin", "admin");
				map.put("pass", "Login Success");
				return "AdminHome";
			}
			else
			{
				map.put("fail","Incorrect Password");
			}
		}
		else
		{
			map.put("fail", "Incorrect Email");
		}
		return "Login";
	}

	public  String fetchAllProducts(ModelMap model)
	{
		List<Product> list=productsrepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No products available");
			return "AdminHome";
		}
		else
		{
			model.put("products", list);
			return "AdminDisplayProduct";
		}
	}
	public String changeStatus(ModelMap model, int id) {
		Product product=productsrepository.findById(id).orElse(null);
		if(product.isStatus())
		{
			product.setStatus(false);
		}
		else {
			product.setStatus(true);
		}
		productsrepository.save(product);
		model.put("pass", "Status Changed Success");
		List<Product> list=productsrepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Products Found");
			return "AdminHome";
		}
		else {
			model.put("products", list);
			return "AdminDisplayProduct";
		}
	}

	public String approvemerchant(ModelMap map) {
		List<Merchant> list=merchantRepository.findAll();
		if(list.isEmpty())
		{
			map.put("fail","No Products Found");
			return "AdminHome";		
		}else {
			map.put("merchants", list);
			return "AdminMerchnatDisplay";
		}
	}

	public String viewCustomers(ModelMap model) {
		List<Customer> list=customerRepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Products Found");
			return "AdminHome";
		}
		else {
			model.put("customers", list);
			return "AdminDisplayCustomer";
		}
	}
public String addPaymentPage(Payment payment, ModelMap model) {
		
		Payment payment2=paymentrepository.findByName(payment.getName());
		if(payment2==null)
		{
		paymentrepository.save(payment);
		model.put("pass", "Payment method Added Successfully");
		return "AdminHome";
		}
		else {
			model.put("fail", "Payment method Already Exists");
			return "AddPaymentOption";
		}
	}
}