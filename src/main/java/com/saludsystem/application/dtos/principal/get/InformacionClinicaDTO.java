package com.saludsystem.application.dtos.principal.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class InformacionClinicaDTO {

    private UUID informacionClinicaId;

    private String nombre;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}