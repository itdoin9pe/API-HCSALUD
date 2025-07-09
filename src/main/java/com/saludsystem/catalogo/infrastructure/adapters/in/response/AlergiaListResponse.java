package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearAlergiaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlergiaListResponse {
    @Schema(description = "Lista de Alergias")
    private List<CrearAlergiaDTO> data;
    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;
}