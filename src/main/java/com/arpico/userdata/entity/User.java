package com.arpico.userdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_data")
public class User implements SuperEntity{

    @Id
    @Column(name = "user_id",length = 20)
    private String userId;

    @Column(nullable = false, length = 45,name = "user_name")
    @NotNull(message = "First user Name is mandatory")
    private String userName;

    @Column(nullable = false, length = 15,name = "password")
    @NotNull(message = "First password is mandatory")
    private String password;

    @Column(nullable = false, name = "mobile")
    @NotNull(message = "First mobile is mandatory")
    private int mobile;
}
