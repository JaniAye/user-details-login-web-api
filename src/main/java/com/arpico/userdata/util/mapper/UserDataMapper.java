package com.arpico.userdata.util.mapper;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDataMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<UserDTO> pageToUserDTO(Page<User> users);
    List<User> toUserAll(List<UserDTO> userDTOS);
}
