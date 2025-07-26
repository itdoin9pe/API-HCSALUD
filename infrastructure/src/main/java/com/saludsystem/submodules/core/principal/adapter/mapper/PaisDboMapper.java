package com.saludsystem.submodules.core.principal.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.PaisEntity;
import com.saludsystem.submodules.principal.model.Pais;

import java.util.UUID;

public class PaisDboMapper {

    public static PaisEntity toEntity(Pais model, UUID userId, UUID hospitalId) {
        PaisEntity entity = new PaisEntity();
        entity.setId(model.getId());
        entity.setIso(model.getIso());
        entity.setNombre(model.getNombre());
        entity.setOrden(model.getOrden());
        entity.setGentilicio(model.getGentilicio());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Pais toDomain(PaisEntity entity) {
        return new Pais(entity.getId(), entity.getIso(), entity.getNombre(), entity.getGentilicio(),
                entity.getOrden());
    }

}
