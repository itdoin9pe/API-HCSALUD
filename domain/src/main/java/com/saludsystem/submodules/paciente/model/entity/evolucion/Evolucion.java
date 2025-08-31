package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Evolucion {
    private UUID pacienteEvolucionId;
    private UUID pacienteId;
    private LocalDateTime fechaInicio;
    private Boolean finalizada = false;
    private List<Nota> notas;
    private List<CambioCondicion> cambios;
    private Long pacienteAltaMedicaId;

    public Evolucion(UUID pacienteEvolucionId, UUID pacienteId, LocalDateTime fechaInicio, Boolean finalizada, 
    		List<Nota> notas, List<CambioCondicion> cambios, Long pacienteAltaMedicaId) {
    	this.pacienteEvolucionId=pacienteEvolucionId;
    	this.pacienteId=pacienteId;
    	this.fechaInicio=fechaInicio;
    	this.finalizada=finalizada;
    	this.notas=notas;
    	this.cambios=cambios;
    	this.pacienteAltaMedicaId=pacienteAltaMedicaId;
    }
}