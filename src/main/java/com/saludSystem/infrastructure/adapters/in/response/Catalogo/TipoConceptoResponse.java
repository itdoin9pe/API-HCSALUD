package com.saludSystem.infrastructure.adapters.in.response.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoConceptoResponse {

    @Schema(description = "Lista de Tipos de conceptos")
    private List<TipoConceptoDTO> data;

    @Schema(description = "Número total de tipos de conceptos", example = "0")
    private long totalData;

}