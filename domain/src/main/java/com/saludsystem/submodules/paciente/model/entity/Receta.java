package com.saludsystem.submodules.paciente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Receta {
    private UUID pacienteRecetaId;
    private LocalDate fecha;
    private UUID doctorId;
    private UUID pacienteId;
    private String observaciones;
    private Integer estado;
    private List<MedicamentoRecetado> medicamentosRecetados;
    
    public Receta(UUID pacienteRecetaId, LocalDate fecha, UUID doctorId, UUID pacienteId, String observaciones,
    		Integer estado, List<MedicamentoRecetado> medicamentoRecetados) {
    	this.pacienteRecetaId=pacienteRecetaId;
    	this.fecha=fecha;
    	this.doctorId=doctorId;
    	this.pacienteId=pacienteId;
    	this.observaciones=observaciones;
    	this.estado=estado;
    	this.medicamentosRecetados=medicamentoRecetados;
    }
}