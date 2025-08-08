package com.saludsystem.submodules.paciente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PacienteConsentimiento {

    private UUID pacienteConsentimientoId;
    private UUID pacienteId;
    private UUID consentimientoId;
    private String cuerpo;
    private LocalDate fecha;
    private LocalTime hora;
    private String apoderadoNombre;
    private String apoderadoDocumento;
    private String apoderadoDireccion;
    private UUID doctorId;
    private Integer estado;
    private byte[] firma;
}
