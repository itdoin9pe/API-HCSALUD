package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaMatListResponse {

    @Schema(description = "Lista de Categorias Materiales")
    private List<com.saludsystem.operaciones.application.dto.res.CategoriaMatResponse> data;

    @Schema(description = "Total de categoria nateriales", example = "0")
    private long totalData;

}