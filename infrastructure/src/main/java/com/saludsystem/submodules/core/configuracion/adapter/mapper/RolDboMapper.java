package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;

import java.util.UUID;

public class RolDboMapper {

    public static RoleEntity toEntity(Rol model, UUID hospitalId) {

        RoleEntity entity = new RoleEntity();
        entity.setRoleId(model.getRoleId());
        entity.setEstado(model.getEstado());
        entity.setNombre(model.getNombre());

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Rol toDomain(RoleEntity entity) {

        return new Rol(entity.getRoleId(), entity.getNombre(), entity.getEstado());

    }

}
