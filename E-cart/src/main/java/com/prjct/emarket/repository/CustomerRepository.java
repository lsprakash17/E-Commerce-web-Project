package com.prjct.emarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.emarket.dto.Customer;
import com.prjct.emarket.dto.Merchant;

public interface CustomerRepository extends JpaRepository<Customer, String>
{
	 Customer findByEmail(String email);
	 Customer findByMobile(long mobile);
}
