package com.saludsystem.submodules.movimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioCreateCommand {

    private UUID productoId;

    private UUID almacenId;

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