package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class EPago {

    private UUID pecPagoId;
    private UUID pacEstadoCuentaId;
    private LocalDate fechaPago;
    private Double monto;
    private String metodoPago;
    private String referenciaPago;

}
