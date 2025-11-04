package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Antecedente {
    private UUID pacienteEnfermedadActualId;
    private UUID pacienteId;
    private String motivo;
    private String enfermedad;
    private String tiempoEnfermedad;
    private String signo;
    private String relato;
    private String funciones;
    private String antecedentesPersonales;
    private String antecedentesFamiliares;
    private String medicamento;
    private String nombreMedicamento;
    private String motivoMedicamento;
    private String dosis;

    public Antecedente(UUID pacienteEnfermedadActualId, UUID pacienteId, String motivo, String enfermedad, 
    		String tiempoEnfermedad, String signo, String relato, String funciones, String antecedentesPersonales,
    		String antecedentesFamiliares, String medicamento, String nombreMedicamento, String moticoMedicamento,
    		String dosis) {
    	this.pacienteEnfermedadActualId=pacienteEnfermedadActualId;
    	this.pacienteId=pacienteId;
    	this.motivo=motivo;
    	this.enfermedad=enfermedad;
    	this.tiempoEnfermedad=tiempoEnfermedad;
    	this.signo=signo;
    	this.relato=relato;
    	this.funciones=funciones;
    	this.antecedentesPersonales=antecedentesPersonales;
    	this.antecedentesFamiliares=antecedentesFamiliares;
    	this.medicamento=medicamento;
    	this.nombreMedicamento=nombreMedicamento;
    	this.motivoMedicamento=moticoMedicamento;
    	this.dosis=dosis;
    }
}