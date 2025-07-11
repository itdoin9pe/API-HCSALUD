package com.saludsystem.application.catalogo.dtos.put;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarApoderadoDTO extends BaseDTO {
    private UUID apoderadoId;
    private String nombre;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    @Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}