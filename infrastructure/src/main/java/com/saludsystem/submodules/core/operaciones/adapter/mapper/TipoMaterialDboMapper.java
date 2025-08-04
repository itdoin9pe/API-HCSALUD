package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.TipoMaterialEntity;
import com.saludsystem.submodules.operaciones.model.TipoMaterial;

import java.util.UUID;

public class TipoMaterialDboMapper {

    public static TipoMaterialEntity toEntity(TipoMaterial model, UUID userId, UUID hospitalId) {

        TipoMaterialEntity entity = new TipoMaterialEntity();
        entity.setTipoMaterialId(model.getTipoMaterialId());
        entity.setNombre(model.getNombre());
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

    public static TipoMaterial toDomain(TipoMaterialEntity entity) {
        return new TipoMaterial(entity.getTipoMaterialId(), entity.getNombre(), entity.getDescripcion(),
                entity.getEstado());
    }

}
