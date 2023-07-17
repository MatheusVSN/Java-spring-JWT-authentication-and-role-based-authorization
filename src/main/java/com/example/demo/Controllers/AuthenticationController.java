package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DataTransferObjects.LoginResponseDTO;
import com.example.demo.DataTransferObjects.RegistrationDTO;
import com.example.demo.Models.ApplicationUser;
import com.example.demo.Services.AuthenticationService;

@RestController
@RequestMapping("/authentication")
@CrossOrigin("*")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.loginUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }
}
