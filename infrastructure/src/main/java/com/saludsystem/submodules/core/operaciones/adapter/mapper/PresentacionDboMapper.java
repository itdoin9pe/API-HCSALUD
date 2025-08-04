package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.PresentacionEntity;
import com.saludsystem.submodules.operaciones.model.Presentacion;

import java.util.UUID;

public class PresentacionDboMapper {

    public static PresentacionEntity toEntity(Presentacion model, UUID userId, UUID hospitalId) {

        PresentacionEntity entity = new PresentacionEntity();
        entity.setNombre(model.getNombre());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Presentacion toDomain(PresentacionEntity entity) {
        return new Presentacion(entity.getPresentacionId(), entity.getNombre(), entity.getEstado());
    }

}
