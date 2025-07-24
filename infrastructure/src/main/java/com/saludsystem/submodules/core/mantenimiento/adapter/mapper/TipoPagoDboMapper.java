package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;

import java.util.UUID;

public class TipoPagoDboMapper {

    public static TipoPagoEntity toEntity(TipoPago model, UUID userId, UUID hospitalId) {

        TipoPagoEntity entity = new TipoPagoEntity();
        entity.setTipoPagoId(model.getTipoPagoId());
        entity.setDescripcion(model.getDescripcion());
        entity.setMetodoPago(model.getMetodoPago());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static TipoPago toDomain(TipoPagoEntity entity) {
        return new TipoPago(entity.getTipoPagoId(), entity.getMetodoPago(), entity.getDescripcion(),
                entity.getEstado());
    }

}
