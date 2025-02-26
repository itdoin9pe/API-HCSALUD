package com.saludSystem.dtos.configuration.Rol;

import com.saludSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarRolDTO {

    private UUID roleId;

    private Integer estado;

    private String nombre;

}