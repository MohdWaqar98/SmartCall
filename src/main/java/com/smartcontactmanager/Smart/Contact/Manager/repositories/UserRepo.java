package com.smartcontactmanager.Smart.Contact.Manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcontactmanager.Smart.Contact.Manager.entities.User;
import java.util.Optional;



@Repository
public interface UserRepo extends JpaRepository<User,String>{
    Optional<User> findByEmail(String email);
}
