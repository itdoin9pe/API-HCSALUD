package com.saludsystem.submodules.core.paciente.adapter.mapper;

import com.saludsystem.submodules.core.catalogo.adapter.entity.ConsentimientoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PConsentimientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;

import java.util.UUID;

public class PConsentimientoDboMapper {

    public static PConsentimientoEntity toEntity(PacienteConsentimiento model, UUID hospitalId, UUID userId) {

        PConsentimientoEntity entity = new PConsentimientoEntity();
        entity.setPacienteConsentimientoId(model.getPacienteConsentimientoId());

        // Paciente
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(pacienteEntity);

        // Consentimiento
        ConsentimientoEntity consentimientoEntity = new ConsentimientoEntity();
        consentimientoEntity.setConsentimientoId(model.getConsentimientoId());
        entity.setConsentimientoEntity(consentimientoEntity);

        entity.setCuerpo(model.getCuerpo());
        entity.setFecha(model.getFecha());
        entity.setHora(model.getHora());
        entity.setApoderadoNombre(model.getApoderadoNombre());
        entity.setApoderadoDocumento(model.getApoderadoDocumento());
        entity.setApoderadoDireccion(model.getApoderadoDireccion());

        // Doctor (puede ser null)
        if (model.getDoctorId() != null) {
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setDoctorId(model.getDoctorId());
            entity.setDoctorEntity(doctorEntity);
        }

        entity.setEstado(model.getEstado());
        entity.setFirma(model.getFirma());

        // Auditoría
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static PacienteConsentimiento toDomain(PConsentimientoEntity entity) {
        return new PacienteConsentimiento(
                entity.getPacienteConsentimientoId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getConsentimientoEntity().getConsentimientoId(),
                entity.getCuerpo(),
                entity.getFecha(),
                entity.getHora(),
                entity.getApoderadoNombre(),
                entity.getApoderadoDocumento(),
                entity.getApoderadoDireccion(),
                entity.getDoctorEntity() != null ? entity.getDoctorEntity().getDoctorId() : null,
                entity.getEstado(),
                entity.getFirma()
        );
    }

}
