package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class SedeDboMapper {

    public static SedeEntity toEntity(Sede model, UUID userId, UUID hospitalId) {

        SedeEntity entity = new SedeEntity();
        entity.setSedeId(model.getId());
        entity.setCodigo(model.getCodigo());
        entity.setNombre(model.getNombre());
        entity.setDireccion(model.getDireccion());
        entity.setUbigeo(model.getUbigeo());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Sede toDomain(SedeEntity entity) {

        return new Sede(entity.getSedeId(), entity.getCodigo(), entity.getNombre(), entity.getDireccion(),
                entity.getUbigeo(), entity.getEstado());

    }

}
