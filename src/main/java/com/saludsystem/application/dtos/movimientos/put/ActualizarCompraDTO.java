package com.saludsystem.application.dtos.movimientos.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarCompraDTO {

    private UUID compraId;
    private LocalDate fecha;
    private String tipoDocumento;
    private String nroDocumento;
    private UUID proveedorId;
    private UUID tipoPagoId;
    private UUID almacenId;

    @Schema(example = "0")
    private BigDecimal efectivo;

    private String guiaRemision;
    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}