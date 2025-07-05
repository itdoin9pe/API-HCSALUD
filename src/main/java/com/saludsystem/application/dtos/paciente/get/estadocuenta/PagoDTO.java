package com.saludsystem.application.dtos.paciente.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PagoDTO {

    private UUID pecPagoId;

    private UUID pacEstadoCuentaId;

    private LocalDate fechaPago;

    @Schema(example = "0")
    private Double monto;

    private String metodoPago;

    private String referenciaPago;

}