package com.saludSystem.application.dtos.Paciente.POST.HistorialClinico;

import lombok.Data;

import java.util.UUID;

@Data
public class CrearPacienteAlergiaDTO {

    private UUID alergiaId;

    private String observacion;

    private Integer estado;

}