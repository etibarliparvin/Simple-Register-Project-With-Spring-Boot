package com.example.simpleregister.controllers;

import com.example.simpleregister.business.abstracts.UserService;
import com.example.simpleregister.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        userService.add(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("listUsers", userList);
        return "users";
    }

    @GetMapping("/login")
    public String login(String email, String password) {
        Optional<User> user = userService.findUserByEmailAndPassword(email, password);
        if (user.isPresent()) return "user";
        else return "index";
    }
}
