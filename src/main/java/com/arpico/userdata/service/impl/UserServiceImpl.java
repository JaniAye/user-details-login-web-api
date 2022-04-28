package com.arpico.userdata.service.impl;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.dto.paginatedDto.PaginatedUserDTO;
import com.arpico.userdata.exception.EntryDuplicateException;
import com.arpico.userdata.exception.NotFoundException;
import com.arpico.userdata.repo.UserRepo;
import com.arpico.userdata.service.UserService;
import com.arpico.userdata.util.mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public String addUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUsername())) {
           return userRepo.save(userDataMapper.toUser(dto)).getUsername();
        } else {
            throw new EntryDuplicateException("User is already exists");

        }


    }

    @Override
    public UserDTO searchUserById(String userName) {
        UserDTO userDTO = userDataMapper.toUserDTO(userRepo.findByUsername(userName));

        if (userDTO!=null) {

            return userDTO;

        } else {
            throw new NotFoundException("User not exists");

        }



    }

    @Override
    public String updateUserData(UserDTO dto) {

        if (userRepo.existsById(dto.getUsername())) {
            return userRepo.save(userDataMapper.toUser(dto)).getUsername();
        } else {
            throw new EntryDuplicateException("no entry");
        }
    }


}
