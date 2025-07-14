package com.saludsystem.application.mantenimiento.dtos.put;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarTarifarioDTO extends BaseDTO {

    private UUID tarifarioId;

    private UUID tipoConceptoId;

    private UUID medidaId;

    private UUID categoriaId;

    private UUID unidadId;

    private String grupo;

    private String descripcion;

    @Schema(description = "Precio del tarifario", example = "0")
    private Double precio;

    @Schema(description = "Estado del tarifario (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
