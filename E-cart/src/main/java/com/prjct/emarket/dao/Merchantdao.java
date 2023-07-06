package com.prjct.emarket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.repository.MerchantRepository;

@Component
public class Merchantdao 
{
	@Autowired
    MerchantRepository merchantRepository;
	
	public Merchant  findByEmail(String email)
	{
		return merchantRepository.findByEmail(email);
	}
	public Merchant findByMobile(long mobile) 
	{
		return merchantRepository.findByMobile(mobile);
	}
	public Merchant save(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
}
