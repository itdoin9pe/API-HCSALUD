package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.res.CategoriaRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaListResponse {

    @Schema(description = "Lista de Categorias - Catalogo")
    private List<CategoriaRequest> data;

    @Schema(description = "Número total de Categorias Registradas", example = "0")
    private long totalData;

}