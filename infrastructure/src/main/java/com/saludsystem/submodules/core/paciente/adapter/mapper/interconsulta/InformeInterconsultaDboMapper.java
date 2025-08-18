package com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InformeInterconsultaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InterconsultaEntity;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;

import java.util.UUID;

public class InformeInterconsultaDboMapper {

    public static InformeInterconsultaEntity toEntity(InformeInterconsulta model, UUID hospitalId, UUID userId) {

        InformeInterconsultaEntity entity = new InformeInterconsultaEntity();
        entity.setPacienteInformeInterconsultaId(model.getPacienteInformeInterconsultaId());

        InterconsultaEntity interconsulta = new InterconsultaEntity();
        interconsulta.setPacienteInterconsultaId(model.getPacienteInterconsultaId());
        entity.setInterconsultaEntity(interconsulta);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setDoctorId(model.getMedicoResponsable());
        entity.setMedicoResponsable(doctor);
        entity.setFecha(model.getFecha());
        entity.setResumenClinico(model.getResumenClinico());
        entity.setDiagnostico(model.getDiagnostico());
        entity.setRecomendaciones(model.getRecomendaciones());
        entity.setArchivoAdjuntoUrl(model.getArchivoAdjuntoUrl());

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        return entity;

    }

    public static InformeInterconsulta toDomain(InformeInterconsultaEntity entity) {

        return new InformeInterconsulta(entity.getPacienteInformeInterconsultaId(),
                entity.getInterconsultaEntity().getPacienteInterconsultaId(),
                entity.getMedicoResponsable().getDoctorId(), entity.getFecha(), entity.getResumenClinico(),
                entity.getDiagnostico(), entity.getRecomendaciones(), entity.getArchivoAdjuntoUrl());

    }

}
