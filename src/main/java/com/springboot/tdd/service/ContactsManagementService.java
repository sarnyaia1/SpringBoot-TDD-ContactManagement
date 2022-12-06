package com.springboot.tdd.service;

import com.springboot.tdd.domain.CustomerContact;
import com.springboot.tdd.repository.CustomerContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactsManagementService {

	private final CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		
		CustomerContact newContact = null;
		
		if (aContact.getFirstName() != null && aContact.getLastName() != null) {
			newContact =  customerContactRepository.save(aContact);
		}
		
		return newContact;	
	}
}
