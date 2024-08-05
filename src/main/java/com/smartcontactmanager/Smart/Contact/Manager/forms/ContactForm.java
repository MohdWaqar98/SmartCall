package com.smartcontactmanager.Smart.Contact.Manager.forms;

import org.springframework.web.multipart.MultipartFile;

import com.smartcontactmanager.Smart.Contact.Manager.validators.ValidFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactForm {
    
    @NotBlank(message= "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message= "Invalid Email Address [example@gmail.com]")
    private String email;

    @NotBlank(message= "Phone Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    private String description;

    private boolean favourite;

    private String InstaLink;

    @ValidFile(message="Invalid File")
    private MultipartFile contactImage;

    private String picture;

}
