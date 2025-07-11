package com.saludsystem.application.movimiento.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarInventarioDTO extends BaseDTO {

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