package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedicamentoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.MedicamentoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.MedicamentoDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoMysqlRepository implements MedicamentoRepository {

    private final MedicamentoJpaRepository medicamentoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public MedicamentoMysqlRepository(MedicamentoJpaRepository medicamentoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.medicamentoJpaRepository = medicamentoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Medicamento save(Medicamento medicamento) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedicamentoEntity entity = MedicamentoDboMapper.toEntity(medicamento, userId, hospitalId);
        return MedicamentoDboMapper.toDomain(medicamentoJpaRepository.save(entity));
    }

    @Override
    public Medicamento update(UUID uuid, Medicamento medicamento) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedicamentoEntity entity = MedicamentoDboMapper.toEntity(medicamento, userId, hospitalId);
        return MedicamentoDboMapper.toDomain(medicamentoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        medicamentoJpaRepository.deleteById(uuid);
    }
}
