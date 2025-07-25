package com.saludsystem.submodules.movimiento.response;

import com.saludsystem.submodules.movimiento.model.dtos.post.CrearInventarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class InventarioListResponse {

    @Schema(description = "Lista de registros para Inventario")
    private List<CrearInventarioDTO> data;

    @Schema(description = "Total de registros para Inventario", example = "0")
    private long totalData;

}