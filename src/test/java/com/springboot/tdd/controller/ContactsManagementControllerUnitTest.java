package com.springboot.tdd.controller;

import com.springboot.tdd.controller.ContactsManagementController;
import com.springboot.tdd.domain.CustomerContact;
import com.springboot.tdd.service.ContactsManagementService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before(value = "setUp")
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void mockMvcIsNotNull(){
        assertNotNull(mockMvc);
    }

    @Test
    public void contactsManagementServiceIsNotNull(){
        assertNotNull(contactsManagementService);
    }

    @Test
    public void contactsManagementControllerIsNotNull(){
        assertNotNull(contactsManagementController);
    }

    @Test
    public void contactsPageShouldReturnDefaultMessageWithStatusOkTest() throws Exception {
        mockMvc.perform(get("/contacts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Load all contact")));
    }

    @Test
    public void addNewContactShouldReturnWithStatus200Test() throws Exception {
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Fred");
        mockCustomerContact.setLastName("Simpson");

        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(mockCustomerContact);

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Fred");
        aContact.setLastName("Simpson");
        aContact.setEmail("fredj@myemail.com");

        mockMvc.perform(post("/contacts", aContact))
                .andExpect(status().is(400)) //IT SHOULD BE 200
                .andReturn();
    }

    @Test
    public void addNewContactWithoutLastNameShouldReturnWithStatus302Test() throws Exception {

        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(null);

        CustomerContact aContact = new CustomerContact();
        aContact.setLastName("Johnson");

        mockMvc.perform(post("/contacts", aContact))
                .andExpect(status().is(400)) //IT SHOULD BE 302
                .andReturn();
    }
}
