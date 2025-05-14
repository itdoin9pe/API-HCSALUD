package com.saludSystem.application.dtos.Configuracion.POST;

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
    //private byte[] photo;
    private String photo;
    public String username;
    public String password;
    private Integer estado;
    private UUID roleId;

}