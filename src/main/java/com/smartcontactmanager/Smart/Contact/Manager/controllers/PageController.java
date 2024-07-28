package com.smartcontactmanager.Smart.Contact.Manager.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

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
    public String register(){
        return "register";
    }
}
