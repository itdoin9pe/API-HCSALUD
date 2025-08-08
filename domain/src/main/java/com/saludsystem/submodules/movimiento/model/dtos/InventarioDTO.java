package com.saludsystem.submodules.movimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioDTO {

    private String nombreAlmacen;

    private String nombreProducto;

    private String nombreMarca;

    private String nombreCategoria;

    @Schema(example = "0")
    private BigDecimal precioEntrada;

    @Schema(example = "string")
    private String unidad;

    @Schema(example = "0")
    private Integer stock;

}