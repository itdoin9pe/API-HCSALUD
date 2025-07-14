package com.saludsystem.application.paciente.dtos.put.historialclinico;

import com.saludsystem.application.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarAntecedenteDTO extends BaseDTO {

    private UUID pacEnfermedadActualId;

    protected UUID pacienteId;

    protected String motivo;

    protected String enfermedad;

    protected String tiempoEnfermedad;

    protected String signo;

    protected String relato;

    protected String funciones;

    protected String antecedentesPersonales;

    protected String antecedentesFamiliares;

    protected String medicamento;

    protected String nombreMedicamento;

    protected String motivoMedicamento;

    protected String dosis;
}
