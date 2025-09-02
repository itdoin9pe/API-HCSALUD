package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProveedorEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.ProveedorJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.ProveedorDboMapper;
import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.port.repository.ProveedorRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProveedorMysqlRepository implements ProveedorRepository {

    private final ProveedorJpaRepository proveedorJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ProveedorMysqlRepository(ProveedorJpaRepository proveedorJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.proveedorJpaRepository = proveedorJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ProveedorEntity entity = ProveedorDboMapper.toEntity(proveedor, userId, hospitalId);
        return ProveedorDboMapper.toDomain(proveedorJpaRepository.save(entity));
    }

    @Override
    public Proveedor update(UUID uuid, Proveedor proveedor) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ProveedorEntity entity = ProveedorDboMapper.toEntity(proveedor, userId, hospitalId);
        return ProveedorDboMapper.toDomain(proveedorJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        proveedorJpaRepository.deleteById(uuid);
    }

}
