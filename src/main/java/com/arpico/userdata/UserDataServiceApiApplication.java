package com.arpico.userdata;

import com.arpico.userdata.util.mapper.UserDataMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2

public class UserDataServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataServiceApiApplication.class, args);
    }



}
