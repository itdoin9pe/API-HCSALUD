package com.saludsystem.submodules.core.paciente.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioMedicoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioResultadoEntity;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.principal.model.Estudio;

import java.util.UUID;

public class EstudioResultadoDboMapper {

    public static EstudioResultadoEntity toEntity(EstudioResultado model, UUID hospitalId, UUID userId) {

        EstudioResultadoEntity entity = new EstudioResultadoEntity();
        entity.setId(model.getId());
        entity.setReporteTexto(model.getReporteTexto());
        entity.setUrlImg(model.getUrlImg());

        EstudioMedicoEntity estudioMedico = new EstudioMedicoEntity();
        estudioMedico.setId(model.getEstudioMedicoId());
        entity.setEstudioMedicoEntity(estudioMedico);

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static EstudioResultado toDomain(EstudioResultadoEntity entity) {

        return new EstudioResultado(
                entity.getId(),
                entity.getReporteTexto(),
                entity.getUrlImg(),
                entity.getEstudioMedicoEntity().getId());

    }

}
