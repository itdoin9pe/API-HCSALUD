package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class EPago {
    private UUID pecPagoId;
    private UUID pacEstadoCuentaId;
    private LocalDate fechaPago;
    private Double monto;
    private String metodoPago;
    private String referenciaPago;

    public EPago(UUID pecPagoId, UUID pacEstadoCuentaId, LocalDate fechaPago, 
    		Double monto, String metodoPago, String referenciaPago) {
    	this.pecPagoId=pecPagoId;
    	this.pacEstadoCuentaId=pacEstadoCuentaId;
    	this.fechaPago=fechaPago;
    	this.monto=monto;
    	this.metodoPago=metodoPago;
    	this.referenciaPago=referenciaPago;
    }
}