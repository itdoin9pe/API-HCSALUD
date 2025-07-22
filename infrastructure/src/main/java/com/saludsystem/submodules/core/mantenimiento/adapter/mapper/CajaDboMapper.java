package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.CajaEntity;
import com.saludsystem.submodules.mantenimiento.model.Caja;

import java.util.UUID;

public class CajaDboMapper {

    public static CajaEntity toEntity(Caja model, UUID userId, UUID hospitalId) {
        CajaEntity entity = new CajaEntity();
        entity.setCajaId(model.getId());
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

    public static Caja toDomain(CajaEntity entity) {
        return new Caja(entity.getCajaId(), entity.getNombre(), entity.getEstado());
    }
}
