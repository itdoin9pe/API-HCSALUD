package com.saludsystem.submodules.paciente.model.entity.interconsulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Interconsulta {

    private UUID pacienteInterconsultaId;

    private UUID pacienteEntity;

    private UUID medicoSolicitante;

    private UUID especialidadDestino;

    private String motivo;

    private LocalDateTime fechaSolicitud;

    private String estado;

    private String prioridad;

    private String observaciones;

    private LocalDateTime fechaAtencion;

}
