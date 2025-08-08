package com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EPagoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;

import java.util.UUID;

public class EPagoDboMapper {

    public static EPagoEntity toEntity(EPago model, UUID userId, UUID hospitalId) {
        if (model == null) return null;

        EPagoEntity entity = new EPagoEntity();
        entity.setIdPago(model.getPecPagoId());

        // Relación con EstadoCuenta
        if (model.getPacEstadoCuentaId() != null) {
            var estadoCuentaEntity = new EstadoCuentaEntity();
            estadoCuentaEntity.setPec_estadoCuentaId(model.getPacEstadoCuentaId());
            entity.setEstadoCuentaEntity(estadoCuentaEntity);
        }

        entity.setFechaPago(model.getFechaPago());
        entity.setMonto(model.getMonto());
        entity.setMetodoPago(model.getMetodoPago());
        entity.setReferenciaPago(model.getReferenciaPago());

        // Auditoría
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static EPago toDomain(EPagoEntity entity) {
        if (entity == null) return null;

        return new EPago(
                entity.getIdPago(),
                entity.getEstadoCuentaEntity() != null ? entity.getEstadoCuentaEntity().getPec_estadoCuentaId() : null,
                entity.getFechaPago(),
                entity.getMonto(),
                entity.getMetodoPago(),
                entity.getReferenciaPago()
        );
    }

}
