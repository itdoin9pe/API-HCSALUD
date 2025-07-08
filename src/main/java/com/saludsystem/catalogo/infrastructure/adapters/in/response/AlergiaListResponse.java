package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.res.AlergiaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlergiaListResponse {
    @Schema(description = "Lista de Alergias")
    private List<AlergiaResponse> data;
    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;
}