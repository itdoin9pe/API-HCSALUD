package com.saludsystem.submodules.movimiento.model.dtos;

import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CompraDTO {

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
    private List<CompraDetalleCreateCommand> detalles;

}