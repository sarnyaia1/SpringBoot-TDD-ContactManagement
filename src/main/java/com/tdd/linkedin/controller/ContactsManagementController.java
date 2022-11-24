package com.tdd.linkedin.controller;

import com.tdd.linkedin.model.CustomerContact;
import com.tdd.linkedin.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ContactsManagementController {

    @Autowired
    private ContactsManagementService contactsManagementService;

    @GetMapping("/")
    public @ResponseBody String loadHomePageContext(){
        return "Hello World";
    }

    //Update!!!
    @GetMapping("/contacts")
    public String getAllContacts(){
        return "Load all contact";
    }

    //Update!!!
    @GetMapping("/contacts/{firstName}")
    public String getContactByFirstName(){
        return "Load contact";
    }

    //Update!!!
    @GetMapping("/contacts/{lastName}")
    public String getContactByLastName(){
        return "Load contact";
    }


    //Update!!!
    @PutMapping("/contacts")
    public String getContactByLastName(@RequestBody CustomerContact aContact){
        return "Update contact";
    }

    @PostMapping("/contacts")
    public String addNewContact(@RequestBody CustomerContact aContact) {
        CustomerContact newContact = contactsManagementService.add(aContact);

        if (newContact != null) {
            return "Add new contact is SUCCESSFUL";
        }
        return "Add new contact is UNSUCCESSFUL";
    }
}
