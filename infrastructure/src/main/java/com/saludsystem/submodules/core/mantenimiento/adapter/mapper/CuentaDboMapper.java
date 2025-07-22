package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.CuentaEntity;
import com.saludsystem.submodules.mantenimiento.model.Cuenta;

import java.util.UUID;

public class CuentaDboMapper {

    public static CuentaEntity toEntity(Cuenta model, UUID userId, UUID hospitalId) {

        CuentaEntity entity = new CuentaEntity();
        entity.setCuentaPagarId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setTotal(model.getTotal());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static Cuenta toDomain(CuentaEntity entity) {
        return new Cuenta(entity.getCuentaPagarId(), entity.getNombre(),
                entity.getTotal(), entity.getEstado());
    }
}
