package com.saludsystem.paciente.application.dto.put;

import com.saludsystem.paciente.application.dto.get.HoraDTO;
import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarPConsentimientoDTO extends BaseDTO {

    private UUID pacienteConsentimientoId;

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
