package com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.PlanTratamientoEntity;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;

import java.util.UUID;

public class PlanTratamientoDboMapper {

    public static PlanTratamientoEntity toEntity(PlanTratamiento model, UUID userId, UUID hospitalId) {

        PlanTratamientoEntity entity = new PlanTratamientoEntity();
        entity.setPacientePlanTratamientoId(model.getPacientePlanTratamientoId());
        entity.setFechaInicio(model.getFechaInicio());
        entity.setFechaFin(model.getFechaFin());

        // Paciente
        var pacienteEntity = new PacienteEntity();
        pacienteEntity.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(pacienteEntity);

        // Doctor
        var doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorId(model.getDoctorId());
        entity.setDoctorEntity(doctorEntity);

        // Especialidad
        var especialidadEntity = new EspecialidadEntity();
        especialidadEntity.setEspecialidadId(model.getEspecialidadId());
        entity.setEspecialidadEntity(especialidadEntity);

        // Medida
        var medidaEntity = new MedidaEntity();
        medidaEntity.setMedidaId(model.getMedidaId());
        entity.setMedidaEntity(medidaEntity);

        // Usuario
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        // Hospital
        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static PlanTratamiento toDomain(PlanTratamientoEntity entity) {

        return new PlanTratamiento(
                entity.getPacientePlanTratamientoId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getDoctorEntity().getDoctorId(),
                entity.getEspecialidadEntity().getEspecialidadId(),
                entity.getMedidaEntity().getMedidaId(),
                entity.getFechaInicio(),
                entity.getFechaFin()
        );

    }

}
