package com.smartcontactmanager.Smart.Contact.Manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;
import com.smartcontactmanager.Smart.Contact.Manager.services.ContactService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable String contactId){
        return contactService.getById(contactId);
    }
}
