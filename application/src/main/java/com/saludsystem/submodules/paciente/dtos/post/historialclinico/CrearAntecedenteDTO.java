package com.saludsystem.submodules.paciente.dtos.post.historialclinico;

import lombok.Data;
import java.util.UUID;

@Data
public class CrearAntecedenteDTO {

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