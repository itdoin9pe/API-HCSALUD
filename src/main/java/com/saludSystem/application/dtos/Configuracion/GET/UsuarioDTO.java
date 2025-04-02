package com.saludSystem.application.dtos.Configuracion.GET;

import io.swagger.v3.oas.annotations.media.Schema;
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
    //private byte[] photo;
    private String photo;
    private String username;
    private UUID roleId;

    @Schema(description = "Estado de la Usuario (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}