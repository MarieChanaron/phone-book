package fr.mariech.phonebook;

import fr.mariech.phonebook.entity.Contact;
import fr.mariech.phonebook.entity.Role;
import fr.mariech.phonebook.entity.User;
import fr.mariech.phonebook.repository.RoleRepository;
import fr.mariech.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PhoneBookApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User user1 = new User("user@sauvageboris.fr", passwordEncoder.encode("pwd"));
        Contact c1 = new Contact("Firstname 1", "Lastname 1");
        c1.setUser(user1);

        List<Contact> contactList1 = new ArrayList<>();
        user1.setContactList(contactList1);
        user1.getContactList().add(c1);

        Contact c2 = new Contact("Firstname 2", "Lastname 2");
        c2.setUser(user1);
        user1.getContactList().add(c2);

        user1.setRoleList(Arrays.asList(new Role("USER")));
        userRepository.save(user1);

        User user2 = new User("admin@sauvageboris.fr", passwordEncoder.encode("pwd"));

        Contact c3 = new Contact("Firstname 3", "Lastname 3");
        c3.setUser(user2);
        List<Contact> contactList2 = new ArrayList<>();
        user2.setContactList(contactList2);
        user2.getContactList().add(c3);

        Contact c4 = new Contact("Firstname 4", "Lastname 4");
        c4.setUser(user2);
        user2.getContactList().add(c4);

        user2.setRoleList(Arrays.asList(new Role("ADMIN")));
    }
}
