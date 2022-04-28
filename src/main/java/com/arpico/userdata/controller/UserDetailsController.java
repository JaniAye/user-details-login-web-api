package com.arpico.userdata.controller;

import com.arpico.userdata.dto.UserDTO;
import com.arpico.userdata.service.UserService;
import com.arpico.userdata.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("/api/user-data")
public class UserDetailsController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
           path = "/register"
    )
    public ResponseEntity addUser(@RequestBody UserDTO dto) {
        String id = userService.addUser(dto);
        return new ResponseEntity(
                new StandardResponse(201, id + " success added", dto),
                HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<StandardResponse> updateUser(@Valid @RequestBody UserDTO dto) {
        String id = userService.updateUserData(dto);
        LOGGER.info("updated User Details, Id:" + dto.getUserId());
        return new ResponseEntity(
                new StandardResponse(204, "success", dto),
                HttpStatus.OK
        );

    }

    @GetMapping(
            params = {"userId"})
    public ResponseEntity<StandardResponse> searchUser(
            @RequestParam(value = "userId") String userId

    ) {

        UserDTO userDTO = null;

        userDTO = userService.searchUserById(userId);
        LOGGER.info("Get By Id");


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", userDTO),
                HttpStatus.OK);
    }

}
