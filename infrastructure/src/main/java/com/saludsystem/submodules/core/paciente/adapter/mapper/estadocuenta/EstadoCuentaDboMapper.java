package com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.Pago;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class EstadoCuentaDboMapper {

    public static EstadoCuentaEntity toEntity(EstadoCuenta model, UUID userId, UUID hospitalId) {
        if (model == null) return null;

        EstadoCuentaEntity entity = new EstadoCuentaEntity();
        entity.setPec_estadoCuentaId(model.getEstadoCuentaId());
        // Mapeo de paciente
        if (model.getPacienteId() != null) {
            var pacienteEntity = new PacienteEntity();
            pacienteEntity.setPacienteId(model.getPacienteId());
            entity.setPacienteEntity(pacienteEntity);
        }
        entity.setFechaApertura(model.getFechaApertura());
        entity.setEstado(model.getEstado());
        entity.setTotalHospitalizacion(model.getTotalHospitalizacion());
        entity.setTotalMedicamentosEstudios(model.getTotalMedicamentosEstudios());
        entity.setTotalPagado(model.getTotalPagado());
        entity.setSaldoPendiente(model.getSaldoPendiente());

        // Auditoría
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        // Relacionados (normalmente se mapean en sus mappers correspondientes)
        entity.setCostosHospitalizacion(Collections.emptyList());
        entity.setDetallesMedicamentosEstudios(Collections.emptyList());
        entity.setPagos(Collections.emptyList());

        return entity;
    }

    public static EstadoCuenta toDomain(EstadoCuentaEntity entity) {
        if (entity == null) return null;

        return new EstadoCuenta(
                entity.getPec_estadoCuentaId(),
                entity.getPacienteEntity() != null ? entity.getPacienteEntity().getPacienteId() : null,
                entity.getFechaApertura(),
                entity.getEstado(),
                entity.getTotalHospitalizacion(),
                entity.getTotalMedicamentosEstudios(),
                entity.getTotalPagado(),
                entity.getSaldoPendiente(),
                mapCostosHospitalizacion(entity.getCostosHospitalizacion()),
                mapDetallesMedicamentosEstudios(entity.getDetallesMedicamentosEstudios()),
                mapPagos(entity.getPagos())
        );
    }

    // Estos mapeos puedes delegarlos a mappers de sus propias entidades
    private static List<CostoHospitalizacion> mapCostosHospitalizacion(List<?> list) {
        // TODO: implementar usando CostoHospitalizacionDboMapper si lo tienes
        return Collections.emptyList();
    }

    private static List<DetalleMedicamentoEstudio> mapDetallesMedicamentosEstudios(List<?> list) {
        // TODO: implementar usando DetalleMedicamentoEstudioDboMapper
        return Collections.emptyList();
    }

    private static List<Pago> mapPagos(List<?> list) {
        // TODO: implementar usando PagoDboMapper
        return Collections.emptyList();
    }

}
