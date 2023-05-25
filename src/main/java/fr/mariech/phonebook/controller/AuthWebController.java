package fr.mariech.phonebook.controller;

import fr.mariech.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthWebController {

    private final UserRepository userRepository;

    public AuthWebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/auth/profile";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/auth/profile")
    public String displayUserDetails(Model model) {
        return "auth/profile";
    }

    @GetMapping("/auth/logout")
    public String logout(Model model) {
        return "redirect:/login";
    }

}
