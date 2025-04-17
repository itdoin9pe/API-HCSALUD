package com.saludSystem.application.dtos.Movimientos.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearInventarioDTO {

    private UUID productoId;

    private int tipoInventarioId;

    private UUID marcaMaterialId;

    private UUID categoriaMaterialId;

    private UUID unidadId;

    private BigDecimal precioEntrada;

    private BigDecimal precioSalida;

    private Integer stock;

    private LocalDate fecha;

    @Schema(description = "Estado de registro de inventario (active = 1 / inactive = 0)", example = "0")
    private Integer estado;

}