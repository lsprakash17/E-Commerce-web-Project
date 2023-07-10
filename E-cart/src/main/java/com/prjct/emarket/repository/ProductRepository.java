package com.prjct.emarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.emarket.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	Product findByName(String name);

}