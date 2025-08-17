package com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InterconsultaCreateCommand {

    private UUID pacienteId;

    private UUID medicoSolicitante;

    private UUID especialidadDestino;

    private String motivo;

    private LocalDateTime fechaSolicitud;

    private String estado;

    private String prioridad;

    private String observaciones;

    private LocalDateTime fechaAtencion;

}
