package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.BancoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.BancoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.BancoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.port.service.BancoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoMysqlRepository implements BancoRepository {

    private final BancoJpaRepository bancoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public BancoMysqlRepository(BancoJpaRepository bancoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.bancoJpaRepository = bancoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Banco save(Banco banco) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        BancoEntity entity = BancoDboMapper.toEntity(banco, userId, hospitalId);
        return BancoDboMapper.toDomain(bancoJpaRepository.save(entity));
    }

    @Override
    public Banco update(UUID uuid, Banco banco) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        BancoEntity entity = BancoDboMapper.toEntity(banco, userId, hospitalId);
        return BancoDboMapper.toDomain(bancoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        bancoJpaRepository.deleteById(uuid);
    }
}
