package com.saludsystem.submodules.cita.model.dtos.get;

import com.saludsystem.submodules.cita.model.dtos.post.CrearCitaDTO;
import com.saludsystem.submodules.cita.model.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaDTO extends CrearCitaDTO {

    private UUID citadoId;

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