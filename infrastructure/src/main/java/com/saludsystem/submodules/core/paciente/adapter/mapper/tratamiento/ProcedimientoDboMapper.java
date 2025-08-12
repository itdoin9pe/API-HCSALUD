package com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.ProcedimientoEntity;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;

import java.util.UUID;

public class ProcedimientoDboMapper {

    public static ProcedimientoEntity toEntity(Procedimiento model, UUID userId, UUID hospitalId) {

        ProcedimientoEntity entity = new ProcedimientoEntity();
        entity.setProcedimientoId(model.getProcedimientoId());
        entity.setTipoProcedimiento(model.getTipoProcedimiento());
        entity.setDescripcion(model.getDescripcion());
        entity.setFecha(model.getFecha());
        entity.setResultado(model.getResultado());

        // Paciente
        var pacienteEntity = new PacienteEntity();
        pacienteEntity.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(pacienteEntity);

        // Doctor
        var doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorId(model.getDoctorId());
        entity.setDoctorEntity(doctorEntity);

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

    public static Procedimiento toDomain(ProcedimientoEntity entity) {

        return new Procedimiento(
                entity.getProcedimientoId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getDoctorEntity().getDoctorId(),
                entity.getTipoProcedimiento(),
                entity.getDescripcion(),
                entity.getFecha(),
                entity.getResultado()
        );

    }

}
