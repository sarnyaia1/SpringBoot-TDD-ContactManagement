package com.tdd.linkedin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdd.linkedin.repository.CustomerContactRepository;
import com.tdd.linkedin.model.CustomerContact;

@Service
public class ContactsManagementService {

	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		
		CustomerContact newContact;
		newContact = customerContactRepository.save(aContact);

		return newContact;	
	}
	
	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;
		
		return newContact;	
	}
	*/
}
