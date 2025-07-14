package com.saludsystem.submodules.mantenimiento.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCajaDTO extends BaseDTO {
    private UUID cajaId;
    private String nombre;
    @Schema(description = "Estado de Cajas (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}