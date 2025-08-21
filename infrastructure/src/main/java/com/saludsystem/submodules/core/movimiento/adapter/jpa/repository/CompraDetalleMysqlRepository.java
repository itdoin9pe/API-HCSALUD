package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraDetalleEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.CompraEntity;
import com.saludsystem.submodules.core.movimiento.adapter.jpa.CompraDetalleJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.CompraDetalleDboMapper;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleMysqlRepository implements CompraDetalleRepository {

    private final CompraDetalleJpaRepository compraDetalleJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CompraDetalleMysqlRepository(CompraDetalleJpaRepository compraDetalleJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.compraDetalleJpaRepository = compraDetalleJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public CompraDetalle save(CompraDetalle compraDetalle) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setCompraId(compraDetalle.getCompraId());
        CompraDetalleEntity entity = CompraDetalleDboMapper.toEntity(compraDetalle, compraEntity, userId, hospitalId);
        return CompraDetalleDboMapper.toDomain(compraDetalleJpaRepository.save(entity));
    }

    @Override
    public CompraDetalle update(UUID uuid, CompraDetalle compraDetalle) {
        if (!compraDetalleJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CompraDetalleConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setCompraId(compraDetalle.getCompraId());
        CompraDetalleEntity entity = CompraDetalleDboMapper.toEntity(compraDetalle, compraEntity, userId, hospitalId);
        entity.setCompraDetalleId(uuid);

        return CompraDetalleDboMapper.toDomain(compraDetalleJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!compraDetalleJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CompraDetalleConstant.ID_NOT_FOUND);
        }
        compraDetalleJpaRepository.deleteById(uuid);
    }

}
