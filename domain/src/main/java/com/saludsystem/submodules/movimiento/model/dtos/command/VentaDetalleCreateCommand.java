package com.saludsystem.submodules.movimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalleCreateCommand {

    private UUID productoId;

    private UUID ventaId;

    private String codigoProducto;

    @Schema(example = "0")
    private Integer cantidad;

    @Schema(example = "0")
    private Double precioUnitario;

    @Schema(example = "0")
    private Double subtotal;

}