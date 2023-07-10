package com.prjct.emarket.dto;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
@Component
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int Id;
    private String name;
    private double price;
    private String description;
    private int quantity;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;
    private boolean status;
}
