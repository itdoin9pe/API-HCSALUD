package com.saludSystem.application.dtos.Paciente.GET;

import lombok.Data;

import java.util.UUID;

@Data
public class PacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

    private UUID alergiaId;

    private String observacion;

    private Integer estado;

}