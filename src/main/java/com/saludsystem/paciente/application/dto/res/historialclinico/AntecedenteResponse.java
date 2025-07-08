package com.saludsystem.paciente.application.dto.res.historialclinico;

import lombok.Data;
import java.util.UUID;

@Data
public class AntecedenteResponse {

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

}