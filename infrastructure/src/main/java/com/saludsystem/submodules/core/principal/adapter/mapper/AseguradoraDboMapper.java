package com.saludsystem.submodules.core.principal.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.AseguradoraEntity;
import com.saludsystem.submodules.principal.model.Aseguradora;

import java.util.UUID;

public class AseguradoraDboMapper {

    public static AseguradoraEntity toEntity(Aseguradora model, UUID userId, UUID hospitalId) {

        AseguradoraEntity entity = new AseguradoraEntity();
        entity.setAseguradoraId(model.getAseguradoraId());
        entity.setDescripcion(model.getDescripcion());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Aseguradora toDomain(AseguradoraEntity entity) {
        return new Aseguradora(entity.getAseguradoraId(), entity.getDescripcion(), entity.getEstado());
    }
}
