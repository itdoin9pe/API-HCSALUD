package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.TipoDocumentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class TipoDocumentoDboMapper {

    public static TipoDocumentoEntity toEntity(TipoDocumento model, UUID userId, UUID hospitalId) {

        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setTDocumentoId(model.getId());
        entity.setTipoComprobante(model.getTipoComprobante());
        entity.setSerie(model.getSerie());
        entity.setInicio(model.getInicio());
        entity.setFin(model.getFin());
        entity.setCorrelativoActual(model.getCorrelativoActual());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static TipoDocumento toDomain(TipoDocumentoEntity entity) {

        return new TipoDocumento(entity.getTDocumentoId(), entity.getTipoComprobante(), entity.getSerie(),
                entity.getInicio(), entity.getFin(), entity.getCorrelativoActual(), entity.getEstado());

    }

}
