package com.arpico.userdata.service;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.dto.paginatedDto.PaginatedUserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    public String addUser(UserDTO dto);
    PaginatedUserDTO searchUserById(String propertyId, int page, int size);
    public String updateUserData(UserDTO dto);


}