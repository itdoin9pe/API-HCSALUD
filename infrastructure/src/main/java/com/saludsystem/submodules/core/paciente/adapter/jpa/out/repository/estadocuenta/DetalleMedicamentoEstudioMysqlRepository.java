package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.estadocuenta;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.DetalleMedicamentoEstudioJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.DetalleMedicamentoEstudioDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.DetalleMedicamentoEstudioConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.DetalleMedicamentoEstudioRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DetalleMedicamentoEstudioMysqlRepository implements DetalleMedicamentoEstudioRepository {

    private final DetalleMedicamentoEstudioJpaRepository detalleMedicamentoEstudioJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public DetalleMedicamentoEstudioMysqlRepository(DetalleMedicamentoEstudioJpaRepository detalleMedicamentoEstudioJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.detalleMedicamentoEstudioJpaRepository = detalleMedicamentoEstudioJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public DetalleMedicamentoEstudio save(DetalleMedicamentoEstudio detalleMedicamentoEstudio) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        DetalleMedicamentosEstudiosEntity entity = DetalleMedicamentoEstudioDboMapper
                .toEntity(detalleMedicamentoEstudio, userId, hospitalId);
        return DetalleMedicamentoEstudioDboMapper.toDomain(detalleMedicamentoEstudioJpaRepository.save(entity));
    }

    @Override
    public DetalleMedicamentoEstudio update(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio) {
        if (!detalleMedicamentoEstudioJpaRepository.existsById(uuid)) {
            throw new IllegalArgumentException(DetalleMedicamentoEstudioConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        DetalleMedicamentosEstudiosEntity entity = DetalleMedicamentoEstudioDboMapper
                .toEntity(detalleMedicamentoEstudio, userId, hospitalId);
        return DetalleMedicamentoEstudioDboMapper.toDomain(detalleMedicamentoEstudioJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!detalleMedicamentoEstudioJpaRepository.existsById(uuid)) {
            throw new IllegalArgumentException(DetalleMedicamentoEstudioConstant.ID_NOT_FOUND);
        }
        detalleMedicamentoEstudioJpaRepository.deleteById(uuid);
    }
}
