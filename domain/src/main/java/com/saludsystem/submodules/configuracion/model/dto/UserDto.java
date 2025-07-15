package com.saludsystem.submodules.configuracion.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String documentType;
    private String documentNumber;
    private String photo;
    private UUID rolId;
    private UUID hospitalId;
    @Schema(description = "Estado de usuario (activo = 0, inactivo = 1)", example = "0")
    private Integer estado;
}
