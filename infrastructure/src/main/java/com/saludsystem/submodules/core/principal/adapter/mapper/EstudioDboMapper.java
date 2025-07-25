package com.saludsystem.submodules.core.principal.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EstudioEntity;
import com.saludsystem.submodules.principal.model.Estudio;

import java.util.UUID;

public class EstudioDboMapper {

    public static EstudioEntity toEntity(Estudio model, UUID userId, UUID hospitalId) {

        EstudioEntity entity = new EstudioEntity();
        entity.setEstudioId(model.getId());
        entity.setDescripcion(model.getDescripcion());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Estudio toDomain(EstudioEntity entity) {
        return new Estudio(entity.getEstudioId(), entity.getDescripcion());
    }

}
