package com.saludsystem.submodules.core.paciente.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioMedicoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioResultadoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;

import java.util.UUID;

public class EstudioMedicoDboMapper {

    public static EstudioMedicoEntity toEntity(EstudioMedico model, UUID userId, UUID hospitalId) {

        EstudioMedicoEntity entity = new EstudioMedicoEntity();
        entity.setId(model.getId());
        entity.setTipo(model.getTipo());
        entity.setDescripcion(model.getDescripcion());
        entity.setEstado(model.getEstado());

        PacienteEntity paciente = new PacienteEntity();
        paciente.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(paciente);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setDoctorId(model.getDoctorId());
        entity.setDoctorEntity(doctor);

        EstudioResultadoEntity estudioResultado = new EstudioResultadoEntity();
        estudioResultado.setId(model.getEstudioResultadoId());
        entity.setEstudioResultadoEntity(estudioResultado);

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static EstudioMedico toDomain(EstudioMedicoEntity entity) {

        return new EstudioMedico(
                entity.getId(),
                entity.getTipo(),
                entity.getDescripcion(),
                entity.getEstado(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getDoctorEntity().getDoctorId(),
                entity.getEstudioResultadoEntity().getId());

    }

}
