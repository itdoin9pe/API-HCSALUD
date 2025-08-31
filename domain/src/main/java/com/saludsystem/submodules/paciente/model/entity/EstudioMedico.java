package com.saludsystem.submodules.paciente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class EstudioMedico {
    private Long id;
    private String tipo;
    private String descripcion;
    private String estado;
    private UUID pacienteId;
    private UUID doctorId;
    private Long estudioResultadoId;

    public EstudioMedico(Long id, String tipo, String descripcion, String estado, UUID pacienteId, 
    		UUID doctorId, Long estudioResultadoId) {
    	this.id=id;
    	this.tipo=tipo;
    	this.descripcion=descripcion;
    	this.estado=estado;
    	this.pacienteId=pacienteId;
    	this.doctorId=doctorId;
    	this.estudioResultadoId=estudioResultadoId;
    }
}