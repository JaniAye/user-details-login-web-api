package com.arpico.userdata.service.impl;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.dto.paginatedDto.PaginatedUserDTO;
import com.arpico.userdata.entity.User;
import com.arpico.userdata.exception.EntryDuplicateException;
import com.arpico.userdata.exception.NotFoundException;
import com.arpico.userdata.repo.UserRepo;
import com.arpico.userdata.service.UserService;
import com.arpico.userdata.util.mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public String addUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUserId())) {
           return userRepo.save(userDataMapper.toUser(dto)).getUserId();
        } else {
            throw new EntryDuplicateException("User is already exists");

        }


    }

    @Override
    public UserDTO searchUserById(String userId) {
        UserDTO userDTO = userDataMapper.toUserDTO(userRepo.findByUserId(userId));

        if (userDTO!=null) {

            return userDTO;

        } else {
            throw new NotFoundException("User not exists");

        }



    }

    @Override
    public String updateUserData(UserDTO dto) {

        if (userRepo.existsById(dto.getUserId())) {
            return userRepo.save(userDataMapper.toUser(dto)).getUserId();
        } else {
            throw new EntryDuplicateException("no entry");
        }
    }
}
