package com.springboot.tdd.controller;

import com.springboot.tdd.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

	@Autowired
	private ContactsManagementController contactsManagementController;

	@Test
	public void contactsManagementControllerIsNotNull(){
		assertNotNull(contactsManagementController);
	}

	//Happy Path
	@Test
	public void addNewContactGetSuccessfulMessageTest() {
		CustomerContact contact1 = new CustomerContact();
		contact1.setFirstName("John");
		contact1.setLastName("Doe");
		String outcome = contactsManagementController.processAddContactSubmit(contact1);

		assertNotNull(contact1);
		assertEquals(outcome, "Add new contact is SUCCESSFUL");
	}

	//Unhappy Path1
	@Test
	public void addNewContactGetUnsuccessfulMessageAfterMissedFirstNameTest() {
		CustomerContact contact1 = new CustomerContact();
		contact1.setLastName("Doe");
		String outcome = contactsManagementController.processAddContactSubmit(contact1);

		assertNotNull(contact1);
		assertEquals(outcome, "Add new contact is UNSUCCESSFUL");
	}

	//Unhappy Path2
	@Test
	public void addNewContactGetUnsuccessfulMessageAfterMissedLastNameTest() {
		CustomerContact contact1 = new CustomerContact();
		contact1.setFirstName("John");
		String outcome = contactsManagementController.processAddContactSubmit(contact1);

		assertNotNull(contact1);
		assertEquals(outcome, "Add new contact is UNSUCCESSFUL");
	}
}
