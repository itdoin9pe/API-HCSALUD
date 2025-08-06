package com.saludsystem.submodules.movimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
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

    // Constructor que debe coincidir EXACTAMENTE con el SELECT de la consulta
    public InventarioDTO
    (String nombreAlmacen, String nombreProducto, String nombreMarca, String nombreCategoria, BigDecimal precioEntrada,
     String unidad, Integer stock) {
        this.nombreAlmacen = nombreAlmacen;
        this.nombreProducto = nombreProducto;
        this.nombreMarca = nombreMarca;
        this.nombreCategoria = nombreCategoria;
        this.precioEntrada = precioEntrada;
        this.unidad = unidad;
        this.stock = stock;
    }

}