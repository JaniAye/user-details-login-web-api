package com.arpico.userdata.dto.paginatedDto;

import com.arpico.userdata.dto.SuperDTO;
import com.arpico.userdata.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedUserDTO implements SuperDTO {
    private List<UserDTO> list;
    private long dataCount;
}
