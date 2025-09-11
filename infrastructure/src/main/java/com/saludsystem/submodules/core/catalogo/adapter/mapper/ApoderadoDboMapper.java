package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class ApoderadoDboMapper {

    public static ApoderadoEntity toEntity(Apoderado model, UUID hospitalId, UUID userId) {
        ApoderadoEntity e = new ApoderadoEntity();
        e.setNombre(model.getNombre());
        e.setDireccion(model.getDireccion());
        e.setTipoDocumento(model.getTipoDocumento());
        e.setNroDocumento(model.getNroDocumento());
        e.setTelefono(model.getTelefono());
        e.setEstado(model.getEstado());
        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        e.setHospital(hospitalEntity);
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        e.setUser(userEntity);
        return e;
    }

    public static Apoderado toDomain(ApoderadoEntity e) {
        return new Apoderado(e.getApoderadoId(),
                e.getNombre(),
                e.getDireccion(),
                e.getTipoDocumento(),
                e.getNroDocumento(),
                e.getTelefono(),
                e.getEstado());
    }
}