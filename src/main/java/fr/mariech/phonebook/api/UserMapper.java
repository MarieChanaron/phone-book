package fr.mariech.phonebook.api;

import fr.mariech.phonebook.api.dto.UserDTO;
import fr.mariech.phonebook.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ContactMapper.class})
public interface UserMapper {

    @Mapping(source = "user.contactList", target = "contacts")
    UserDTO userToUserDTO(User user);
}
