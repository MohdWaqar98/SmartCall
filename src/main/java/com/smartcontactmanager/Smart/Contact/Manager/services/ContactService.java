package com.smartcontactmanager.Smart.Contact.Manager.services;

import java.util.List;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;

public interface ContactService {
    Contact save(Contact contact);

    // update contact
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    // get contact by id

    Contact getById(String id);

    // delete contact

    void delete(String id);

    List<Contact> search(String name, String email, String phoneNumber);

    List<Contact> getByUserId(String userId);
}
