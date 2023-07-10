package com.prjct.emarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.prjct.emarket.dto.Product;
import com.prjct.emarket.helper.Login;
import com.prjct.emarket.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService
{
 
	@Autowired
	ProductRepository productsrepository;
		
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
}
