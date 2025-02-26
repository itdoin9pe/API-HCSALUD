package com.saludSystem.dtos.configuration.User;

import com.saludSystem.enums.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDTO {

    private UUID userId;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String phoneNumber;
    private String documentType;
    private String documentNumber;
    private byte[] photo;
    private String username;
    private UUID roleId;
    private Integer estado;

}