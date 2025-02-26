package com.saludSystem.dtos.configuration.Rol;

import com.saludSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearRolDTO {

    private Integer estado;

    private String nombre;

}