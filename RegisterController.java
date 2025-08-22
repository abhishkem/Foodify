package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final UserServices userServices;

    public RegisterController(UserServices userServices) {
        this.userServices = userServices;
    }

    // Show registration form
    @GetMapping("/register.html")
    public String showRegisterForm(Model model) {
        model.addAttribute("userRegistration", new User()); // matches th:object
        return "register"; // register.html in templates folder
    }

    // Handle form submit
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("userRegistration") User user, Model model) {
        User existingUser = userServices.getUserByEmail(user.getUemail());

        if (existingUser != null) {

            model.addAttribute("error", " Email already registered! Try another one.");
            return "register"; // stay on register form
        }


        userServices.addUser(user);
        model.addAttribute("success", " Registration successful! Please login.");
        return "login";
    }
}
