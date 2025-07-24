package com.saludsystem.submodules.core.cita.adapter.mapper;

import com.saludsystem.submodules.cita.model.entity.*;
import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.cita.adapter.entity.CitaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaDboMapper {

    public static CitaEntity toEntity(Cita model, UUID userId, UUID hospitalId) {

        CitaEntity entity = new CitaEntity();
        entity.setCitadoId(model.getId().value());

        DoctorEntity doctor = new DoctorEntity();
        doctor.setDoctorId(model.getDoctorId().value());
        entity.setDoctorEntity(doctor);

        EspecialidadEntity especialidad = new EspecialidadEntity();
        especialidad.setEspecialidadId(model.getEspecialidadId().value());
        entity.setEspecialidadEntity(especialidad);

        entity.setFecha(model.getFecha());
        entity.setHoraInicio(model.getHoraInicio());
        entity.setHoraFin(model.getHoraFin());

        PacienteEntity paciente = new PacienteEntity();
        paciente.setPacienteId(model.getPacienteId().value());
        entity.setPacienteEntity(paciente);

        SedeEntity sede = new SedeEntity();
        sede.setSedeId(model.getSedeId().value());
        entity.setSedeEntity(sede);

        entity.setEstado(model.getEstado());
        entity.setMotivoConsulta(model.getMotivoConsulta().value());
        entity.setObservacion(model.getObservacion().value());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static Cita toDomain(CitaEntity entity) {

        return new Cita(
                new CitaId(entity.getCitadoId()),
                new CitaEspecialidadId(entity.getEspecialidadEntity().getEspecialidadId()),
                new CitaDoctorId(entity.getDoctorEntity().getDoctorId()),
                entity.getFecha(),
                entity.getHoraInicio(),
                entity.getHoraFin(),
                new CitaPacienteId(entity.getPacienteEntity().getPacienteId()),
                new CitaSedeId(entity.getSedeEntity().getSedeId()),
                new CitaTipoCitadoId(entity.getTipoCitadoEntity().getTipoCitadoId()),
                entity.getEstado(),
                new CitaMotivoConsulta(entity.getMotivoConsulta()),
                new CitaObservacion(entity.getObservacion())
        );

    }
}
