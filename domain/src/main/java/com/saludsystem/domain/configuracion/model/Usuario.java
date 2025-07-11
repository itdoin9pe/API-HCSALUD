package com.saludsystem.domain.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Usuario {
    private UUID id;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String documentType;
    private String documentNumber;
    private String username;
    private String password;
    private String estado;
    private String roleId;
}
