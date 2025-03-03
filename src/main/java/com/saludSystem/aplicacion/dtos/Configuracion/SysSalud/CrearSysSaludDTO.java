package com.saludSystem.aplicacion.dtos.Configuracion.SysSalud;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class CrearSysSaludDTO {

    private UUID hospitalId;
    private String nombre;
    private String direccion;
    private String celular;

    @Email(message = "El email debe ser válido")
    private String email;

    private String ruc;
    private Date fecha;
    private byte[] foto;
    private UUID planId;

    @Schema(description = "Estado de la Clinica (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}