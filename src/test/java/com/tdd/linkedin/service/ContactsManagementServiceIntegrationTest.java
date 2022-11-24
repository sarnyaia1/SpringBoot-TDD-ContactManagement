package com.tdd.linkedin.service;

import com.tdd.linkedin.model.CustomerContact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {

	@Autowired
	private ContactsManagementService contactsManagementService;

	@Test
	public void contactsManagementServiceIsNotNull(){
		assertNotNull(contactsManagementService);
	}

	@Test
	public void addNewContactIsNotNullTest() {
		CustomerContact contact1 = new CustomerContact();
		contact1.setFirstName("Jane");
		contact1.setLastName("Doe");

		CustomerContact newContact = contactsManagementService.add(contact1);

		assertNotNull(newContact);
		assertEquals("Jane", newContact.getFirstName());
		assertEquals("Doe", newContact.getLastName());
	}
}
