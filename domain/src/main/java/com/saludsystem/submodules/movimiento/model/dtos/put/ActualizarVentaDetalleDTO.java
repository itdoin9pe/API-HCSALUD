package com.saludsystem.submodules.movimiento.model.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarVentaDetalleDTO extends BaseDTO {

    private UUID productoId;

    private UUID ventaId;

    private UUID ventaDetalleId;

    private String codigoProducto;

    @Schema(example = "0")
    private Integer cantidad;

    @Schema(example = "0")
    private Double precioUnitario;

    @Schema(example = "0")
    private Double subtotal;

}