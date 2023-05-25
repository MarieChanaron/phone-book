package fr.mariech.phonebook.controller;

import fr.mariech.phonebook.entity.User;
import fr.mariech.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserWebController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user-details/{id}")
    public String displayUserDetails(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("");
        if (user.isEmpty()) {

        }
        model.addAttribute("user", user.get());
        return "user_details";
    }

}
