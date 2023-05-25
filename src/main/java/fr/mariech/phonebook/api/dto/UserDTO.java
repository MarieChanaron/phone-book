package fr.mariech.phonebook.api.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String email;
    private List<ContactDTO> contacts;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, List<ContactDTO> contacts) {
        this.id = id;
        this.email = email;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
