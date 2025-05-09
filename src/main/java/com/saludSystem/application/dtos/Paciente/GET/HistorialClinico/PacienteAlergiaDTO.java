package com.saludSystem.application.dtos.Paciente.GET.HistorialClinico;

import lombok.Data;

import java.util.UUID;

@Data
public class PacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

    private UUID alergiaId;

    private String observacion;

    private Integer estado;

}