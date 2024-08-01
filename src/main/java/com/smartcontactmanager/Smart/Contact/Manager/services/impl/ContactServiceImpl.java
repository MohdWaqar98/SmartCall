package com.smartcontactmanager.Smart.Contact.Manager.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;
import com.smartcontactmanager.Smart.Contact.Manager.entities.User;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.ResourceNotFoundException;
import com.smartcontactmanager.Smart.Contact.Manager.repositories.ContactRepo;
import com.smartcontactmanager.Smart.Contact.Manager.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService{


    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Contact save(Contact contact) {
        
        String contactId=UUID.randomUUID().toString();
        contact.setId(contactId);

        return contactRepo.save(contact);
        
    }

    @Override
    public Contact update(Contact contact) {
        throw new UnsupportedOperationException("Unimplemented method");
        
    }

    @Override
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Contact getById(String id) {
        return contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not Found with given Id"+id));
    }

    @Override
    public void delete(String id) {
        var contact=contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not Foun with given Id"+id));
        contactRepo.delete(contact);
    }

    @Override
    public List<Contact> search(String name, String email, String phoneNumber) {
       throw new UnsupportedOperationException("Unimplemented method");
    }

    @Override
    public List<Contact> getByUserId(String userId) {
       return contactRepo.findByUserId(userId);
    }

    @Override
    public Page<Contact> getByUser(User user,int page,int size,String sortBy,String direction) {

        Sort sort = direction.equals("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        var pageable=PageRequest.of(page, size, sort);

        return contactRepo.findByUser(user, pageable);
    }

}
