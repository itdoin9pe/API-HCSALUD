package com.saludsystem.submodules.paciente.model.entity.interconsulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class InformeInterconsulta {

    private UUID pacienteInformeInterconsultaId;
    private UUID pacienteInterconsultaEntity;
    private UUID medicoResponsable;
    private LocalDateTime fecha;
    private String resumenClinico;
    private String diagnostico;
    private String recomendaciones;
    private String archivoAdjuntoUrl;

}
