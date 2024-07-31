package com.smartcontactmanager.Smart.Contact.Manager.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcontactmanager.Smart.Contact.Manager.entities.Contact;
import com.smartcontactmanager.Smart.Contact.Manager.entities.User;
import com.smartcontactmanager.Smart.Contact.Manager.forms.ContactForm;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.Helper;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.Message;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.MessageType;
import com.smartcontactmanager.Smart.Contact.Manager.services.ContactService;
import com.smartcontactmanager.Smart.Contact.Manager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;


    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addContactView(Model model){

        ContactForm contactForm=new ContactForm();


        model.addAttribute("contactForm",contactForm);
        
        return "user/add_contact";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm,BindingResult result, Authentication authentication,HttpSession session){


        if(result.hasErrors()){
            session.setAttribute("message",Message.builder()
            .content("Please correct the following errors!!")
            .type(MessageType.red)
            .build());
            return "user/add_contact";
        }

        String username=Helper.getEmailOfLoggedInUser(authentication);

        User user=userService.getUserByEmail(username);

        Contact contact=new Contact();
        contact.setName(contactForm.getName());
        contact.setFavourite(contactForm.isFavourite());
        contact.setEmail(contactForm.getEmail());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setUser(user);
        contact.setInstaLink(contactForm.getInstaLink());
        contactService.save(contact);
        System.out.println(contactForm);

        session.setAttribute("message",Message.builder()
        .content("You have successfully added a new contact")
        .type(MessageType.green)
        .build());

        return"redirect:/user/contacts/add";
    }
}
