package com.saludsystem.submodules.configuracion.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarUsuarioDTO extends BaseDTO {
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String phoneNumber;
    private String documentType;
    private String documentNumber;
    private String photo;
    private String username;
    private String password;
    private Integer estado;
    private UUID roleId;
}