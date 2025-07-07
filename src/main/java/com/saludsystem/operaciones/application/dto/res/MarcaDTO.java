package com.saludsystem.operaciones.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class MarcaDTO {

    private UUID marcaId;

    private String nombre;

    @Schema(description = "Estado de marca", example = "0")
    private Integer estado;

}