package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Antecedente {

    private UUID pacienteEnfermedadActualId;
    private UUID pacienteEntity;
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

}
