package com.saludsystem.submodules.paciente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PacienteConsentimiento {
    private UUID pacienteConsentimientoId;
    private UUID pacienteId;
    private UUID consentimientoId;
    private String cuerpo;
    private LocalDate fecha;
    private LocalTime hora;
    private String apoderadoNombre;
    private String apoderadoDocumento;
    private String apoderadoDireccion;
    private UUID doctorId;
    private Integer estado;
    private byte[] firma;
    
    public PacienteConsentimiento(UUID pacienteConsentimientoId, UUID pacienteId, UUID consentimientoId, String cuerpo,
    		LocalDate fecha, LocalTime hora, String apoderadoNombre, String apoderadoDocumento, String apoderadoDireccion,
    		UUID doctorId, Integer estado, byte[] firma) {
    	this.pacienteConsentimientoId=pacienteConsentimientoId;
    	this.pacienteId=pacienteId;
    	this.consentimientoId=consentimientoId;
    	this.cuerpo=cuerpo;
    	this.fecha=fecha;
    	this.hora=hora;
    	this.apoderadoNombre=apoderadoNombre;
    	this.doctorId=doctorId;
    	this.estado=estado;
    	this.firma=firma;
    }
}