package com.saludsystem.submodules.cita.model.dtos;

import com.saludsystem.submodules.cita.model.vo.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CitaDTO {

    private UUID citadoId;
    private UUID tipoCitadoId;
    private UUID especialidadId;
    private UUID doctorId;
    private LocalDate fecha;
    @Schema(example = "10:00:00")
    private LocalTime horaInicio;
    @Schema(example = "11:00:00")
    private LocalTime horaFin;
    private UUID pacienteId;
    private UUID sedeId;
    private String estado;
    private String motivoConsulta;
    private String observacion;

    public CitaDTO(CitaId id, CitaDoctorId doctorId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                   CitaPacienteId pacienteId, CitaSedeId sedeId, CitaTipoCitadoId tipoCitadoId, String estado,
                   CitaMotivoConsulta motivoConsulta, CitaObservacion observacion) {
        this.setCitadoId(id.value());
        this.setDoctorId(doctorId.value());
        this.setFecha(fecha);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setPacienteId(pacienteId.value());
        this.setSedeId(sedeId.value());
        this.setTipoCitadoId(tipoCitadoId.value());
        this.setEstado(estado);
        this.setMotivoConsulta(motivoConsulta.value());
        this.setObservacion(observacion.value());
    }

}