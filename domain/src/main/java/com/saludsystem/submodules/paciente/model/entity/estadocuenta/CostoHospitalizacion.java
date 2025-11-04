package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CostoHospitalizacion {
    private UUID pec_costoHospitalizacionId;
    private UUID estadoCuentaId;
    private UUID pacienteId;
    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
    private String tipoHabitacion;
    private Double costoPorDia;
    private Integer cantidadDias;
    private Double totalCosto;
    
    public CostoHospitalizacion(UUID pec_costoHospitalizacionId, UUID estadoCuentaId, UUID pacienteId, 
    		LocalDate fechaIngreso, LocalDate fechaAlta, String tipoHabitacion, Double costoPorDia,
    		Integer cantidadDias, Double totalCosto) {
    	this.pec_costoHospitalizacionId=pec_costoHospitalizacionId;
    	this.estadoCuentaId=estadoCuentaId;
    	this.pacienteId=pacienteId;
    	this.fechaIngreso=fechaIngreso;
    	this.fechaAlta=fechaAlta;
    	this.tipoHabitacion=tipoHabitacion;
    	this.costoPorDia=costoPorDia;
    	this.cantidadDias=cantidadDias;
    	this.totalCosto=totalCosto;
    }
}