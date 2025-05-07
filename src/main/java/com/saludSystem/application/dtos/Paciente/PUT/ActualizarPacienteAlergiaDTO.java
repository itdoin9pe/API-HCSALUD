package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarPacienteAlergiaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteAlergiaId;

    private UUID alergiaId;

    private String observacion;

    private Integer estado;

}