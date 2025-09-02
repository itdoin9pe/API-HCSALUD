package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.CompraJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.CompraDboMapper;
import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.constant.CompraConstant;
import com.saludsystem.submodules.movimiento.port.repository.CompraRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraMysqlRepository implements CompraRepository {

    private final CompraJpaRepository compraJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CompraMysqlRepository(CompraJpaRepository compraJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.compraJpaRepository = compraJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Compra save(Compra compra) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        CompraEntity entity = CompraDboMapper.toEntity(compra, hospitalId, userId);
        return CompraDboMapper.toDomain(compraJpaRepository.save(entity));
    }

    @Override
    public Compra update(UUID uuid, Compra compra) {
        if (!compraJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CompraConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        CompraEntity entity = CompraDboMapper.toEntity(compra, hospitalId, userId);
        return CompraDboMapper.toDomain(compraJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!compraJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CompraConstant.ID_NOT_FOUND);
        }
        compraJpaRepository.deleteById(uuid);
    }

}
