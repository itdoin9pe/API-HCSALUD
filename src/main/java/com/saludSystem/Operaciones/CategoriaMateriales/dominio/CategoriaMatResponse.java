package com.saludSystem.Operaciones.CategoriaMateriales.dominio;

import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.CategoriaMatDTO;
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