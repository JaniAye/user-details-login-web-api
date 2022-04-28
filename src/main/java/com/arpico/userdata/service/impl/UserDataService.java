package com.arpico.userdata.service.impl;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.exception.NotFoundException;
import com.arpico.userdata.repo.UserRepo;
import com.arpico.userdata.util.mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDataMapper userDataMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO userDTO = userDataMapper.toUserDTO(userRepo.findByUsername(userName));

        if (userDTO!=null) {

            return new User(userDTO.getUsername(),userDTO.getPassword(), new ArrayList<>());

        } else {
            throw new NotFoundException("Incorrect User name or password");

        }



    }
}
