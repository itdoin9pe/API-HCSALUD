package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductoListResponse {

    @Schema(description = "Lista de productos registrados")
    private List<com.saludsystem.operaciones.application.dto.res.ProductoResponse> data;

    @Schema(description = "Total de productos registrados", example = "0")
    private long totalData;

}