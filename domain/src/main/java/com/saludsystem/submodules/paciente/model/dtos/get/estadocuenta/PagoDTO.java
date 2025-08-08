package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagoDTO {

    private UUID pecPagoId;

    private UUID pacEstadoCuentaId;

    private LocalDate fechaPago;

    @Schema(example = "0")
    private Double monto;

    private String metodoPago;

    private String referenciaPago;

}