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
public class InformeInterconsultaCreateCommand {

    private UUID pacienteInterconsultaId;

    private UUID medicoResponsable;

    private LocalDateTime fecha;

    private String resumenClinico;

    private String diagnostico;

    private String recomendaciones;

    private String archivoAdjuntoUrl;

}
