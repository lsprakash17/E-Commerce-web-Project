package com.prjct.emarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.emarket.dto.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, String>
{

	Merchant findByEmail(String email);

	Merchant findByMobile(long mobile);

}
