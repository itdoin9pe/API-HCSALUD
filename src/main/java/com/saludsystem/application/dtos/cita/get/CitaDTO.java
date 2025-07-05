package com.saludsystem.application.dtos.cita.get;

import com.saludsystem.application.dtos.cita.CitaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CitaDTO extends CitaBaseDTO {

    private UUID citadoId;
    /*
    private UUID especialidadEntity;
    private UUID doctorEntity;
    private LocalDate fecha;
    @Schema(example = "10:00:00")
    private LocalTime horaInicio;
    @Schema(example = "11:00:00")
    private LocalTime horaFin;
    private UUID pacienteEntity;
    private UUID sedeEntity;
    private UUID tipoCitadoEntity;
    private String estado;
    private String motivoConsulta;
    private String observacion;*/
}