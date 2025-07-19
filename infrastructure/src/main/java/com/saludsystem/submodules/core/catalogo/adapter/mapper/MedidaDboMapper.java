package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class MedidaDboMapper {

    public static MedidaEntity toEntity(Medida model, UUID userId, UUID hospitalId) {
        MedidaEntity e = new MedidaEntity();
        e.setNombre(model.getNombre());
        e.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        e.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        e.setHospital(hospitalEntity);

        return e;
    }

    public static Medida toDomain(MedidaEntity e) {
        return new Medida(e.getMedidaId(),
                e.getNombre(),
                e.getEstado());
    }
}