package fr.mariech.phonebook.api;

import fr.mariech.phonebook.api.UserMapper;
import fr.mariech.phonebook.api.dto.UserDTO;
import fr.mariech.phonebook.entity.User;
import fr.mariech.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> specificUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UserDTO userDTO = userMapper.userToUserDTO(user.get());
        return ResponseEntity.ok(userDTO);
    }

}
