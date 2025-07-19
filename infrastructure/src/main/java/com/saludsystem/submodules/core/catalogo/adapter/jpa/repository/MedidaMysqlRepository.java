package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.MedidaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.MedidaDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaMysqlRepository implements MedidaRepository {

    private final MedidaJpaRepository medidaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public MedidaMysqlRepository(MedidaJpaRepository medidaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.medidaJpaRepository = medidaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Medida save(Medida medida) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedidaEntity entity = MedidaDboMapper.toEntity(medida, userId, hospitalId);
        return MedidaDboMapper.toDomain(medidaJpaRepository.save(entity));
    }

    @Override
    public Medida update(UUID uuid, Medida medida) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MedidaEntity entity = MedidaDboMapper.toEntity(medida, userId, hospitalId);
        return MedidaDboMapper.toDomain(medidaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        medidaJpaRepository.deleteById(uuid);
    }
}
