package com.saludSystem.Configuracion.SysSalud.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ActualizarHospitalDTO {

    private UUID hospitalId;
    private String nombre;
    private String direccion;
    private String celular;

    @Email(message = "El email debe ser válido")
    private String email;

    private String ruc;
    private Date fecha;
    private String foto;
    private UUID planId;

    @Schema(description = "Estado de la Clinica (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}