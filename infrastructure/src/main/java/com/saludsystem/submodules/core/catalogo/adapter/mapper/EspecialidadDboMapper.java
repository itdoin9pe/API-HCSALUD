package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;

import java.util.UUID;

public class EspecialidadDboMapper {

    public static EspecialidadEntity toEntity(Especialidad model, UUID userId, UUID hospitalId) {
        EspecialidadEntity entity = new EspecialidadEntity();
        entity.setEspecialidadId(model.getId());
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

    public static Especialidad toDomain(EspecialidadEntity entity) {
        return new Especialidad(entity.getEspecialidadId(), entity.getNombre(),
        		entity.getDescripcion(), entity.getEstado());
    }
}