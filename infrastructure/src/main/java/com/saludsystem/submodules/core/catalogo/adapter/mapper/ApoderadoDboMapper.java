package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class ApoderadoDboMapper {

    public static ApoderadoEntity toEntity(Apoderado model, UUID userId, UUID hospitalId) {
        ApoderadoEntity e = new ApoderadoEntity();
        e.setNombre(model.getNombre());
        e.setDireccion(model.getDireccion());
        e.setTelefono(model.getTelefono());
        e.setNroDocumento(model.getNroDocumento());
        e.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        e.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        e.setHospital(hospitalEntity);

        return e;
    }

    public static Apoderado toDomain(ApoderadoEntity e) {
        return new Apoderado(e.getApoderadoId(),
                e.getNombre(),
                e.getNroDocumento(),
                e.getTelefono(),
                e.getDireccion(),
                e.getEstado());
    }
}