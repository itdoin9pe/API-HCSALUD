package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearTipoConceptoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoConceptoListResponse {

    @Schema(description = "Lista de Tipos de conceptos")
    private List<CrearTipoConceptoDTO> data;

    @Schema(description = "Número total de tipos de conceptos", example = "0")
    private long totalData;

}