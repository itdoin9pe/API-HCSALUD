package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ConsentimientoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class ConsentimientoDboMapper {

    public static ConsentimientoEntity toEntity(Consentimiento model, UUID userId, UUID hospitalId) {
        ConsentimientoEntity e = new ConsentimientoEntity();
        e.setTexto(model.getTexto());
        e.setNombre(model.getNombre());
        e.setObservacion(model.getObservacion());
        e.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        e.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        e.setHospital(hospitalEntity);
        return e;
    }

    public static Consentimiento toDomain(ConsentimientoEntity e) {
        return new Consentimiento(e.getConsentimientoId(),
                e.getNombre(),
                e.getObservacion(),
                e.getEstado(),
                e.getTexto());
    }

}