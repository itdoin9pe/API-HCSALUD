package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PConsentimientoDTO {

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

    /*
    public PConsentimientoDTO(UUID pacienteConsentimientoId, UUID pacienteId, UUID consentimientoId, String cuerpo,
                              LocalDate fecha, HoraDTO horaDTO, String apoderadoNombre, String apoderadoDocumento,
                              String apoderadoDireccion, UUID doctorId, Integer estado, byte[] firma) {
        this.pacienteConsentimientoId = pacienteConsentimientoId;
        this.pacienteId = pacienteId;
        this.consentimientoId = consentimientoId;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.hora = horaDTO;
        this.apoderadoNombre = apoderadoNombre;
        this.apoderadoDocumento = apoderadoDocumento;
        this.apoderadoDireccion = apoderadoDireccion;
        this.doctorId = doctorId;
        this.estado = estado;
        this.firma = firma;
    }*/

}