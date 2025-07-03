package com.saludsystem.application.dtos.paciente.put.historialclinico;

import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarAntecedenteDTO {

    private UUID hospitalId;

    private UUID userId;

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