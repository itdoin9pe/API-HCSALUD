package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class PacienteAlergia {
    private UUID pacienteAlergiaId;
    private UUID pacienteId;
    private UUID alergiaId;
    private String observacion;
    private Integer estado;

    public PacienteAlergia(UUID pacienteAlergiaId, UUID pacienteId, UUID alergiaId, String observacion, Integer estado) {
    	this.pacienteAlergiaId=pacienteAlergiaId;
    	this.pacienteId=pacienteId;
    	this.alergiaId=alergiaId;
    	this.observacion=observacion;
    	this.estado=estado;
    }
}