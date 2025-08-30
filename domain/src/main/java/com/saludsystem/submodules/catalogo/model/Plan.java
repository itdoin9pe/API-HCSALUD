package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter 
@NoArgsConstructor
public class Plan {
    private UUID id;
    private String nombrePlan;
    private LocalDate fechaInicio;
    private LocalDate fechaFinContrato;
    private int maxPlan;
    private int useMax;
    private Double costoPlan;
    private Integer estado;
    
    public Plan(UUID id, String nombrePlan, LocalDate fechaInicio, LocalDate fechaFinContrato, int maxPlan, int useMax, 
    		Double costoPlan, Integer estado) {
    	this.id=id;
    	this.nombrePlan=nombrePlan;
    	this.fechaInicio=fechaInicio;
    	this.fechaFinContrato=fechaFinContrato;
    	this.maxPlan=maxPlan;
    	this.useMax=useMax;
    	this.costoPlan=costoPlan;
    	this.estado=estado;
    }
}