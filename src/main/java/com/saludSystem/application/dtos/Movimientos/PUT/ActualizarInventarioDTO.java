package com.saludSystem.application.dtos.Movimientos.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarInventarioDTO {

    private UUID productoId;

    @Schema(example = "0")
    private int tipoInventarioId;

    private UUID marcaMaterialId;

    private UUID categoriaMaterialId;

    private UUID unidadId;

    @Schema(example = "0")
    private BigDecimal precioEntrada;

    @Schema(example = "0")
    private BigDecimal precioSalida;

    @Schema(example = "0")
    private Integer stock;

    private LocalDate fecha;

    @Schema(description = "Estado de registro de inventario (active = 1 / inactive = 0)", example = "0")
    private Integer estado;

}