package com.arpico.userdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO {
   private String userId;
    private String userName;
    private String password;
    private int mobile;
}
