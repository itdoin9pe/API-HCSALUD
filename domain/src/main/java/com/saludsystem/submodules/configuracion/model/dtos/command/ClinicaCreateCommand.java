package com.saludsystem.submodules.configuracion.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClinicaCreateCommand {
    private String nombre;
    private String direccion;
    private String celular;
    @Email(message = "El email debe ser válido")
    private String email;
    private String ruc;
    private Date fecha;
    private String foto;
    private UUID planId;
    @Schema(example = "0")
    private Integer estado;
}