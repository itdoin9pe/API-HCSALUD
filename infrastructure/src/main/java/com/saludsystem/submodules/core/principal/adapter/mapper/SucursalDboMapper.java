package com.saludsystem.submodules.core.principal.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;
import com.saludsystem.submodules.principal.model.Sucursal;

import java.util.UUID;

public class SucursalDboMapper {

    public static SucursalEntity toEntity(Sucursal model, UUID hospitalId) {
        SucursalEntity entity = new SucursalEntity();
        entity.setSucursalId(model.getSucursalId());
        entity.setNombre(model.getNombre());
        entity.setDireccion(model.getDireccion());
        entity.setDefault(model.isDefault());

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static Sucursal toDomain(SucursalEntity entity) {
        return new Sucursal(
                entity.getSucursalId(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.isDefault()
        );
    }

}
