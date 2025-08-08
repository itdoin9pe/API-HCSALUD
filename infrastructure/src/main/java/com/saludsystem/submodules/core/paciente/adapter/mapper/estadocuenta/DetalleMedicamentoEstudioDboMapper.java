package com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;

import java.util.UUID;

public class DetalleMedicamentoEstudioDboMapper {

    public static DetalleMedicamentosEstudiosEntity toEntity(
            DetalleMedicamentoEstudio model, UUID userId, UUID hospitalId) {

        DetalleMedicamentosEstudiosEntity entity = new DetalleMedicamentosEstudiosEntity();
        entity.setPec_detalleMedicamentoId(model.getPec_detalleMedicamentoId());

        PacienteEntity paciente = new PacienteEntity();
        paciente.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(paciente);

        EstadoCuentaEntity estadoCuenta = new EstadoCuentaEntity();
        estadoCuenta.setPec_estadoCuentaId(model.getEstadoCuentaId());
        entity.setEstadoCuentaEntity(estadoCuenta);

        entity.setTipo(model.getTipo());
        entity.setDescripcion(model.getDescripcion());
        entity.setCantidad(model.getCantidad());
        entity.setCostoUnitario(model.getCostoUnitario());
        entity.setTotalCosto(model.getTotalCosto());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static DetalleMedicamentoEstudio toDomain(DetalleMedicamentosEstudiosEntity entity) {

        return new DetalleMedicamentoEstudio(
                entity.getPec_detalleMedicamentoId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getEstadoCuentaEntity().getPec_estadoCuentaId(),
                entity.getTipo(),
                entity.getDescripcion(),
                entity.getCantidad(),
                entity.getCostoUnitario(),
                entity.getTotalCosto());

    }

}
