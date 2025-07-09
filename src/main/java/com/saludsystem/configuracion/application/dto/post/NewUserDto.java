package com.saludsystem.configuracion.application.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Estado de la Usuario (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
    private UUID roleId;
}