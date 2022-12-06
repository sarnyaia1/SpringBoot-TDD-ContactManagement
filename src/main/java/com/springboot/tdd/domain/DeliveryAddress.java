package com.springboot.tdd.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery_address")
@Data
public class DeliveryAddress {
	private long id;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zipCode;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
}
