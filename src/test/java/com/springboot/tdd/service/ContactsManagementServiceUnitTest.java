package com.springboot.tdd.service;

import com.springboot.tdd.domain.CustomerContact;
import com.springboot.tdd.repository.CustomerContactRepository;
import com.springboot.tdd.service.ContactsManagementService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {
	
	@Mock
	private CustomerContactRepository customerContactRepository;
	
	@InjectMocks
	private ContactsManagementService contactsManagementService;
	
	
	@Before(value = "setUp")
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void contactsManagementServiceIsNotNull(){
		assertNotNull(contactsManagementService);
	}

	@Test
	public void contactsManagementRepositoryIsNotNull(){
		assertNotNull(customerContactRepository);
	}
	
	@Test
	public void addNewMockContactTest() {
		CustomerContact mockContact1 = new CustomerContact();
		mockContact1.setFirstName("John");
		mockContact1.setLastName("Smith");

		//Mock repository
		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(mockContact1);

		assertEquals("John", mockContact1.getFirstName());
		assertEquals("Smith", mockContact1.getLastName());
	}
}
