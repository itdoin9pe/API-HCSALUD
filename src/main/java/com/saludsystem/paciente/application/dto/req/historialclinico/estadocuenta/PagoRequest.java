package com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PagoRequest {

    private UUID estadoCuentaId;

    private LocalDate fechaPago;

    @Schema(example = "0")
    private Double monto;

    private String metodoPago;

    private String referenciaPago;

}