package com.saludsystem.configuracion.application.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String address;
    private String email;
    private String documentType;
    private String documentNumber;
    private String photo;
    private String username;
    private String password;
    private Integer estado;
    private UUID roleId;

}