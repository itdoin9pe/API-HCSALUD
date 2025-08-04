package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProveedorEntity;
import com.saludsystem.submodules.operaciones.model.Proveedor;

import java.util.UUID;

public class ProveedorDboMapper {

    public static ProveedorEntity toEntity(Proveedor model, UUID userId, UUID hospitalId) {

        ProveedorEntity entity = new ProveedorEntity();
        entity.setProveedorId(model.getProveedorId());
        entity.setNombre(model.getNombre());
        entity.setRuc(model.getRuc());
        entity.setCorreo(model.getCorreo());
        entity.setContacto(model.getContacto());
        entity.setDireccion(model.getDireccion());
        entity.setTelefono(model.getTelefono());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Proveedor toDomain(ProveedorEntity entity) {
        return new Proveedor(entity.getProveedorId(), entity.getNombre(), entity.getRuc(), entity.getCorreo(),
                entity.getContacto(), entity.getDireccion(), entity.getTelefono());
    }

}
