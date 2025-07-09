package com.saludsystem.paciente.application.dto.post;

import com.saludsystem.paciente.application.dto.get.HoraDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearPConsentimientoDTO {

    private UUID pacienteId;

    private UUID consentimientoId;

    private String cuerpo;

    private LocalDate fecha;

    private HoraDTO hora;

    private String apoderadoNombre;

    private String apoderadoDocumento;

    private String apoderadoDireccion;

    private UUID doctorId;

    @Schema(example = "0")
    private Integer estado;

    private byte[] firma;

}