package com.saludsystem.submodules.paciente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class MedicamentoRecetado {
    private UUID id;
    private UUID pacienteRecetaId;
    private UUID medicamentoId;
    private String dosis;
    private String frecuencia;
    private Integer duracionDias;
    private String indicaciones;

    public MedicamentoRecetado(UUID id, UUID pacienteRecetadoId, UUID medicamentoId, String dosis, 
    		String frecuencia, Integer duracionDias, String indicaciones) {
    	this.id=id;
    	this.pacienteRecetaId=pacienteRecetadoId;
    	this.medicamentoId=medicamentoId;
    	this.dosis=dosis;
    	this.frecuencia=frecuencia;
    	this.duracionDias=duracionDias;
    	this.indicaciones=indicaciones;
    }
}