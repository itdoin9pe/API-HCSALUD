package com.saludsystem.submodules.configuracion.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarSedeDTO extends BaseDTO {
    private UUID sedeId;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    @Schema(description = "Estado de la Sede (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}