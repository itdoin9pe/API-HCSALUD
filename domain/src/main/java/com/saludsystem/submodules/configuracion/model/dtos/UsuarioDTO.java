package com.saludsystem.submodules.configuracion.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private UUID userId;

    private String lastName;
    private String firstName;

    @NotBlank
    @Email
    private String email;
    private String username;
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