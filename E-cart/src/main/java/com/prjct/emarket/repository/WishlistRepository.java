package com.prjct.emarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.emarket.dto.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>
{

	Wishlist findByName(String name);

}
