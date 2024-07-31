package com.smartcontactmanager.Smart.Contact.Manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;
import com.smartcontactmanager.Smart.Contact.Manager.entities.User;


@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {

        List<Contact> findByUser(User user);

        @Query("SELECT c FROM Contact c WHERE c.user.id = :userId")
        List<Contact> findByUserId(@Param("userId") String userId);

}
