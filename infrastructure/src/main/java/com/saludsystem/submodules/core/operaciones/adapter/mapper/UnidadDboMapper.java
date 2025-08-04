package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import com.saludsystem.submodules.operaciones.model.Unidad;

import java.util.UUID;

public class UnidadDboMapper {

    public static UnidadEntity toEntity(Unidad model, UUID userId, UUID hospitalId) {

        UnidadEntity entity = new UnidadEntity();
        entity.setUnidadId(model.getUnidadId());
        entity.setNombre(model.getNombre());
        entity.setSiglas(model.getSiglas());
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

    public static Unidad toDomain(UnidadEntity entity) {
        return new Unidad(entity.getUnidadId(), entity.getNombre(), entity.getSiglas(),
                entity.getDescripcion(), entity.getEstado());
    }

}
