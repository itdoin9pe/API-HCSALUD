package com.saludSystem.dtos.configuration;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class SysSaludDTO {
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
    private Integer estado;
}
