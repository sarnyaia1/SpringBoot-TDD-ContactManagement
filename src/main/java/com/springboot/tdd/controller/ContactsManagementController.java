package com.springboot.tdd.controller;

import com.springboot.tdd.domain.CustomerContact;
import com.springboot.tdd.service.ContactsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContactsManagementController {

	private final ContactsManagementService contactsManagementService;

	@GetMapping("/")
	public @ResponseBody String loadHomePageContext(){
		return "Hello World";
	}

	//Update!!!
	@GetMapping("/contacts")
	public @ResponseBody String getAllContacts(){
		return "Load all contact";
	}
	
	@PostMapping("/contacts")
	public String processAddContactSubmit(@RequestBody CustomerContact aContact) {
		
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		if (newContact != null) {
			return "Add new contact is SUCCESSFUL";
		}
		
		return "Add new contact is UNSUCCESSFUL";
	}
}
