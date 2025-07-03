package com.saludsystem.infrastructure.adapters.in.response.movimientos;

import com.saludsystem.application.dtos.movimientos.get.InventarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class InventarioResponse {

    @Schema(description = "Lista de registros para Inventario")
    private List<InventarioDTO> data;

    @Schema(description = "Total de registros para Inventario", example = "0")
    private long totalData;

}