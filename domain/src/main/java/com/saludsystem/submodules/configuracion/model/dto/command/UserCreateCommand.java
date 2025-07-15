package com.saludsystem.submodules.configuracion.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateCommand {
    @Schema(description = "Nombre")
    private String firstName;
    @Schema(description = "Apellido")
    private String lastName;
    @Schema(description = "Email", format = "email")
    private String email;
    private String username;
    private String password;
    @Schema(description = "Teléfono")
    private String phoneNumber;
    @Schema(description = "Dirección")
    private String address;
    @Schema(description = "Tipo de documento")
    private String documentType;
    @Schema(description = "Número de documento")
    private String documentNumber;
    @Schema(description = "Foto", type = "string", format = "binary")
    private String photo;
    @Schema(description = "Rol ID", format = "uuid")
    private UUID rolId;
    private UUID hospitalId;
    @Schema(description = "Estado de usuario (activo = 0, inactivo = 1)", example = "0")
    private Integer estado;
}
