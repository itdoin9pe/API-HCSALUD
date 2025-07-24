package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoGastoEntity;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;

import java.util.UUID;

public class TipoGastoDboMapper {

    public static TipoGastoEntity toEntity(TipoGasto model, UUID userId, UUID hospitalId) {
        TipoGastoEntity entity = new TipoGastoEntity();
        entity.setConceptoGastoId(model.getConceptoGastoId());
        entity.setNombre(model.getNombre());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static TipoGasto toDomain(TipoGastoEntity entity) {
        return new TipoGasto(entity.getConceptoGastoId(), entity.getNombre(), entity.getEstado());
    }
}
