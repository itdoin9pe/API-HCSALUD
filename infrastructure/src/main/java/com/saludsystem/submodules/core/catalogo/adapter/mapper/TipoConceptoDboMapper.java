package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class TipoConceptoDboMapper {
    public static TipoConceptoEntity toEntity(TipoConcepto model, UUID userId, UUID hospitalId) {

        TipoConceptoEntity e = new TipoConceptoEntity();
        e.setTipoConceptoId(model.getId());
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

    public static TipoConcepto toDomain(TipoConceptoEntity e) {
        return new TipoConcepto(e.getTipoConceptoId(), e.getNombre(), e.getEstado());
    }
}
