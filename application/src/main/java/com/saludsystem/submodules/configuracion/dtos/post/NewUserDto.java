package com.saludsystem.submodules.configuracion.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class NewUserDto {
    private String lastName;
    private String firstName;
    @NotBlank
    @Email
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String documentType;
    private String documentNumber;
    private String photo;
    //private MultipartFile photo;
    private UUID roleId;
    private UUID hospitalId;
    @Schema(example = "0")
    private Integer estado;
}