package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class EstadoCuenta {
	private UUID estadoCuentaId;
    private UUID pacienteId;
    private Date fechaApertura;
    private String estado; // Ej: ABIERTA, CERRADA, PAGADA
    private Double totalHospitalizacion;
    private Double totalMedicamentosEstudios;
    private Double totalPagado;
    private Double saldoPendiente;
    private List<CostoHospitalizacion> costosHospitalizacion;
    private List<DetalleMedicamentoEstudio> detallesMedicamentosEstudios;
    private List<EPago> EPagos;
    
    public EstadoCuenta(UUID estadoCuentaId, UUID pacienteId, Date fechaApertura, String estado, 
    		Double totalHospitalizacion, Double totalMedicamentosEstudios, Double totalPagado, 
    		Double saldoPendiente, List<CostoHospitalizacion> costoHospitalizacion, 
    		List<DetalleMedicamentoEstudio> detallesMedicamentosEstudios, List<EPago> EPagos) {
    	this.estadoCuentaId=estadoCuentaId;
    	this.pacienteId=pacienteId;
    	this.fechaApertura=fechaApertura;
    	this.estado=estado;
    	this.totalHospitalizacion=totalHospitalizacion;
    	this.totalMedicamentosEstudios=totalMedicamentosEstudios;
    	this.totalPagado=totalPagado;
    	this.saldoPendiente=saldoPendiente;
    	this.costosHospitalizacion=costoHospitalizacion;
    	this.detallesMedicamentosEstudios=detallesMedicamentosEstudios;
    	this.EPagos=EPagos;
    }
}