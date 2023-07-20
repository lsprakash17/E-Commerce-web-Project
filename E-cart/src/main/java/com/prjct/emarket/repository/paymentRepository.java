package com.prjct.emarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.emarket.dto.Payment;

public interface paymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByName(String name);

}
