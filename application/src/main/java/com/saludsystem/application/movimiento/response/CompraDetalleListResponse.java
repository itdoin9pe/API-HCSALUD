package com.saludsystem.application.movimiento.response;

import com.saludsystem.application.movimiento.dtos.post.CrearCompraDetalleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CompraDetalleListResponse {

    @Schema(description = "Lista de registros - detalles de la compra")
    private List<CrearCompraDetalleDTO> data;

    @Schema(description = "Total de registro - detalles de la compra", example = "0")
    private long totalData;

}