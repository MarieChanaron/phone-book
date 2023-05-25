package fr.mariech.phonebook.api;

import fr.mariech.phonebook.api.dto.ContactDTO;
import fr.mariech.phonebook.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDTO contactToContactDTO(Contact contact);
}
