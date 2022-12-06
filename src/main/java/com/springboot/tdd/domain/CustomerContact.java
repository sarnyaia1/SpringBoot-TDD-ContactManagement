package com.springboot.tdd.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_contact")
@NoArgsConstructor
@Data
public class CustomerContact {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String deliveryAddressLine1;
	private String deliveryAddressLine2;
	private String deliveryAddressCity;
	private String deliveryAddressState;
	private String deliveryAddressLZipCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	

}
