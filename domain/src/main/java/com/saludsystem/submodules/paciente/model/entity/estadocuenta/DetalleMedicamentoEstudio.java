package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class DetalleMedicamentoEstudio {
    private UUID pec_detalleMedicamentoId;
    private UUID pacienteId;
    private UUID estadoCuentaId;
    private String tipo;
    private String descripcion;
    private Integer cantidad;
    private Double costoUnitario;
    private Double totalCosto;

    public DetalleMedicamentoEstudio(UUID pec_detalleMedicamentoId, UUID pacienteId, UUID estadoCuentaId, 
    		String tipo, String descripcion, Integer cantidad, Double costoUnitario, Double totalCosto) {
    	this.pec_detalleMedicamentoId=pec_detalleMedicamentoId;
    	this.pacienteId=pacienteId;
    	this.estadoCuentaId=estadoCuentaId;
    	this.tipo=tipo;
    	this.descripcion=descripcion;
    	this.cantidad=cantidad;
    	this.costoUnitario=costoUnitario;
    	this.totalCosto=totalCosto;
    }
}