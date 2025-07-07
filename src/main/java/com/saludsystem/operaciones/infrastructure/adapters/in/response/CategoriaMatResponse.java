package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import com.saludsystem.operaciones.application.dto.res.CategoriaMatDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaMatResponse {

    @Schema(description = "Lista de Categorias Materiales")
    private List<CategoriaMatDTO> data;

    @Schema(description = "Total de categoria nateriales", example = "0")
    private long totalData;

}