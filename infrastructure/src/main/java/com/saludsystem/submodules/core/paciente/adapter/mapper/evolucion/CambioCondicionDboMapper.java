package com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.CambioCondicionEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.EvolucionEntity;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;

import java.util.UUID;

public class CambioCondicionDboMapper {

    public static CambioCondicionEntity toEntity(CambioCondicion model, UUID userId, UUID hospitalId) {
        CambioCondicionEntity entity = new CambioCondicionEntity();

        entity.setId(model.getId());
        entity.setFecha(model.getFecha());
        entity.setDescripcion(model.getDescripcion());

        // Relación con Evolución
        if (model.getPacienteEvolucionId() != null) {
            EvolucionEntity evolucionEntity = new EvolucionEntity();
            evolucionEntity.setPacienteEvolucionId(model.getPacienteEvolucionId());
            entity.setEvolucionEntity(evolucionEntity);
        }

        // Auditoría
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static CambioCondicion toDomain(CambioCondicionEntity entity) {
        return new CambioCondicion(
                entity.getId(),
                entity.getFecha(),
                entity.getDescripcion(),
                entity.getEvolucionEntity() != null ? entity.getEvolucionEntity().getPacienteEvolucionId() : null
        );
    }

}
