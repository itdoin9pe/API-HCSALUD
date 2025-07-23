package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.MonedaEntity;
import com.saludsystem.submodules.mantenimiento.model.Moneda;

import java.util.UUID;

public class MonedaDboMapper {

    public static MonedaEntity toEntity(Moneda model, UUID userId, UUID hospitalId) {
        MonedaEntity entity = new MonedaEntity();
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

    public static Moneda toDomain(MonedaEntity entity) {
        return new Moneda(entity.getMonedaId(), entity.getDescripcion(), entity.getEstado());
    }

}
