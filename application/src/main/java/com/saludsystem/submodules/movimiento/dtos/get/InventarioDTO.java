package com.saludsystem.submodules.movimiento.dtos.get;

import com.saludsystem.submodules.movimiento.dtos.post.CrearInventarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class InventarioDTO extends CrearInventarioDTO {

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