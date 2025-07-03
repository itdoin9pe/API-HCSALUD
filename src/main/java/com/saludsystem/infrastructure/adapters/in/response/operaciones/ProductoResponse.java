package com.saludsystem.infrastructure.adapters.in.response.operaciones;

import com.saludsystem.application.dtos.operaciones.get.ProductoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductoResponse {

    @Schema(description = "Lista de productos registrados")
    private List<ProductoDTO> data;

    @Schema(description = "Total de productos registrados", example = "0")
    private long totalData;

}