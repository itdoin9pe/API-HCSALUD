package com.saludSystem.application.dtos.Movimientos.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class InventarioDTO {

    private UUID inventarioId;

    @Schema(example = "string")
    private String nombreAlmacen;

    @Schema(example = "string")
    private String nombreProducto;

    private UUID tipoInventarioId;

    @Schema(example = "0")
    private BigDecimal precioEntrada;

    @Schema(example = "0")
    private BigDecimal precioSalida;

    @Schema(example = "string")
    private String unidad;

    @Schema(example = "0")
    private Integer stock;

    private LocalDate fechaRegistro;

    @Schema(description = "Estado de registro de inventario (active = 1 / inactive = 0)", example = "0")
    private Integer estado;

}