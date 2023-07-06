package com.prjct.emarket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prjct.emarket.dto.Customer;
import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.repository.CustomerRepository;

@Component
public class Customerdao 
{
@Autowired
CustomerRepository Repository;

public Customer  findByEmail(String email)
{
	return Repository.findByEmail(email);
}
public Customer findByMobile(long mobile) 
{
	return Repository.findByMobile(mobile);
}
public Customer save(Customer merchant) {
	return Repository.save(merchant);
}
}
