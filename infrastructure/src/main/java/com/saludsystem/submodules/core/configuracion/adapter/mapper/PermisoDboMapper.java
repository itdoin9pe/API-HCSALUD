package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.core.configuracion.adapter.entity.PermisoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.MenuEntity;

import java.util.UUID;

public class PermisoDboMapper {

    public static PermisoEntity toEntity(Permiso model, UUID hospitalId, UUID userId) {

        PermisoEntity entity = new PermisoEntity();
        entity.setPermisoId(model.getId());
        entity.setInsert(model.getInsert());
        entity.setRead(model.getRead());
        entity.setUpdate(model.getUpdate());
        entity.setDelete(model.getDelete());

        var rol = new RoleEntity();
        rol.setRoleId(model.getRolId());
        entity.setRol(rol);

        var menu = new MenuEntity();
        menu.setMenuId(model.getMenuId());
        entity.setMenuEntity(menu);

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Permiso toDomain(Permiso model) {

        return new Permiso(
                model.getId(),
                model.getInsert(),
                model.getRead(),
                model.getUpdate(),
                model.getDelete(),
                model.getRolId(),
                model.getMenuId());

    }

}
