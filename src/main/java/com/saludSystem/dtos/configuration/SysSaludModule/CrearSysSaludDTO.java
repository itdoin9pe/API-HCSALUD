package com.saludSystem.dtos.configuration.SysSaludModule;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    //private UUID planId;
    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la Clinica (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;
}
