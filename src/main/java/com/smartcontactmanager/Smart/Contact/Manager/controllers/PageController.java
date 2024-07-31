package com.smartcontactmanager.Smart.Contact.Manager.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcontactmanager.Smart.Contact.Manager.entities.User;
import com.smartcontactmanager.Smart.Contact.Manager.forms.UserForm;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.Message;
import com.smartcontactmanager.Smart.Contact.Manager.helpers.MessageType;
import com.smartcontactmanager.Smart.Contact.Manager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("OwnerName", "Mohd Waqar Ahmed");
        model.addAttribute("GithubRepository", "https://github.com/MohdWaqar98");
        return "home";
    }

    //about page
    @RequestMapping("/about")
    public String aboutpage(){
        System.out.println("About Page Running");
        return "about";
    }  
    
    //services
    @RequestMapping("/services")
    public String servicepage(){
        System.out.println("Service Page Running");
        return "services";
    }     

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model){

        UserForm userForm = new UserForm();
        
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        //fetch form data 

        //validation
        if(rBindingResult.hasErrors()){
            return "register";
        }
        //save to database

        //userservice

        //User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://www.freepik.com/free-photos-vectors/default-profile-pic")
        // .build();

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.freepik.com/free-photos-vectors/default-profile-pic");

        User savedUser=userService.saveUser(user);

        //message

        Message message = Message.builder().content("Registration Successfull 📞").type(MessageType.green).build();
        session.setAttribute("message", message);

        
        return"redirect:/register";
    }
}
