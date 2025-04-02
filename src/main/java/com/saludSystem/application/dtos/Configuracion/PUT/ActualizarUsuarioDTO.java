package com.saludSystem.application.dtos.Configuracion.PUT;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarUsuarioDTO {

    private UUID userId;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String phoneNumber;
    private String documentType;
    private String documentNumber;
    //private byte[] photo;
    private String photo;
    private String username;
    private String password;
    private Integer estado;
    private UUID roleId;

}