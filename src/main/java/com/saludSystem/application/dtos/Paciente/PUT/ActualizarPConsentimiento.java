package com.saludSystem.application.dtos.Paciente.PUT;

import com.saludSystem.application.dtos.Paciente.GET.HoraDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarPConsentimiento {

    private UUID hospitalId;

    private UUID userId;

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