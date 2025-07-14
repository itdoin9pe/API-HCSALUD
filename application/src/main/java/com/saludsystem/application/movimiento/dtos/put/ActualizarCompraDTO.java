package com.saludsystem.application.movimiento.dtos.put;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCompraDTO extends BaseDTO {

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