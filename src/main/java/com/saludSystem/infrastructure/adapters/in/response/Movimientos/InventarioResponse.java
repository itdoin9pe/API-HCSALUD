package com.saludSystem.infrastructure.adapters.in.response.Movimientos;

import com.saludSystem.application.dtos.Movimientos.GET.InventarioDTO;
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