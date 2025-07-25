package com.saludsystem.submodules.configuracion.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class NewUserDto {
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String documentType;
    private String documentNumber;
    private String photo;
    private UUID roleId;
    private UUID hospitalId;
    @Schema(example = "0")
    private Integer estado;
}