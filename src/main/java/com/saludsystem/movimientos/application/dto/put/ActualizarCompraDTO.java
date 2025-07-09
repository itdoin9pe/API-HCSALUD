package com.saludsystem.movimientos.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
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