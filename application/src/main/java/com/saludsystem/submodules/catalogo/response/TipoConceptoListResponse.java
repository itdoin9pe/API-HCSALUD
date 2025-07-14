package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.dtos.get.TipoConceptoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoConceptoListResponse {

    @Schema(description = "Lista de Tipos de conceptos")
    private List<TipoConceptoDTO> data;

    @Schema(description = "Número total de tipos de conceptos", example = "0")
    private long totalData;

}