package com.prjct.emarket.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Component
@Data
public class Customer
{
	private String name;
	@Id
	private String email;
	private long mobile;
	private String password;
	private LocalDate dob;
	private String gender;
	private String address;
	private boolean status;
	private String token;

}
