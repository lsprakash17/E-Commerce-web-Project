package com.prjct.emarket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prjct.emarket.dto.Merchant;
import com.prjct.emarket.dto.Product;
import com.prjct.emarket.repository.MerchantRepository;
import com.prjct.emarket.repository.ProductRepository;
@Component
public class Merchantdao 
{
	@Autowired
    MerchantRepository merchantRepository;
	
	
	@Autowired
	ProductRepository productrepository ;
	
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
	public Product findByName(String name) {
		return productrepository.findByName(name);
	}
	public Product findById(int id) {
	 return productrepository.findById(id).orElse(null);
	}
	public void removeProduct(Product product) {
	 productrepository.delete(product);
	}
	public Product findProductById(int id) {
	return productrepository.findById(id).orElse(null);
	}
}
