package com.saludSystem.Catalogo.Categoria.dominio;

import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CategoriaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaResponse {

    @Schema(description = "Lista de Categorias - Catalogo")
    private List<CategoriaDTO> data;

    @Schema(description = "Número total de Categorias Registradas", example = "0")
    private long totalData;

}