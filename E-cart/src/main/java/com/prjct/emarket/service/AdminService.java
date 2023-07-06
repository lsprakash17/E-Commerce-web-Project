package com.prjct.emarket.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.prjct.emarket.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService
{
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
}
