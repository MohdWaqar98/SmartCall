package com.smartcontactmanager.Smart.Contact.Manager.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;
import com.smartcontactmanager.Smart.Contact.Manager.entities.User;

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

    Page<Contact> searchByName(String nameKeyword,int size,int page, String sortBy, String order,User user);

    Page<Contact> searchByEmail(String emailKeyword,int size,int page, String sortBy, String order,User user);

    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword,int size,int page, String sortBy, String order,User user);

    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user,int page,int size,String sortField,String sortDirection);
}
