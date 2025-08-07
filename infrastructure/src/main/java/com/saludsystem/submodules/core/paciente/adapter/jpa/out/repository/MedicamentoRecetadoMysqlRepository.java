package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.MedicamentoRecetadoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.MedicamentoRecetadoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.MedicamentoRecetadoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.port.repository.MedicamentoRecetadoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoRecetadoMysqlRepository implements MedicamentoRecetadoRepository {

    private final MedicamentoRecetadoJpaRepository medicamentoRecetadoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public MedicamentoRecetadoMysqlRepository(MedicamentoRecetadoJpaRepository medicamentoRecetadoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.medicamentoRecetadoJpaRepository = medicamentoRecetadoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public MedicamentoRecetado save(MedicamentoRecetado medicamentoRecetado) {
        UUID userId =authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedicamentoRecetadoEntity entity = MedicamentoRecetadoDboMapper
                .toEntity(medicamentoRecetado, userId, hospitalId);
        return MedicamentoRecetadoDboMapper.toDomain(medicamentoRecetadoJpaRepository.save(entity));
    }

    @Override
    public MedicamentoRecetado update(UUID uuid, MedicamentoRecetado medicamentoRecetado) {
        if (!medicamentoRecetadoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(MedicamentoRecetadoConstant.ID_NOT_FOUND);
        }
        UUID userId =authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedicamentoRecetadoEntity entity = MedicamentoRecetadoDboMapper
                .toEntity(medicamentoRecetado, userId, hospitalId);
        return MedicamentoRecetadoDboMapper.toDomain(medicamentoRecetadoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!medicamentoRecetadoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(MedicamentoRecetadoConstant.ID_NOT_FOUND);
        }
        medicamentoRecetadoJpaRepository.deleteById(uuid);
    }

}
