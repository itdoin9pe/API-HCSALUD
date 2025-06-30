package com.saludSystem.application.dtos.Paciente.POST.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class CrearPacienteAlergiaDTO {

    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}