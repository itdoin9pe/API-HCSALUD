package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.ProductoJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.ProductoDboMapper;
import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.port.repository.ProductoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductoMysqlRepository implements ProductoRepository {

    private final ProductoJpaRepository productoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ProductoMysqlRepository(ProductoJpaRepository productoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.productoJpaRepository = productoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Producto save(Producto producto) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ProductoEntity entity = ProductoDboMapper.toEntity(producto, userId, hospitalId);
        return ProductoDboMapper.toDomain(productoJpaRepository.save(entity));
    }

    @Override
    public Producto update(UUID uuid, Producto producto) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ProductoEntity entity = ProductoDboMapper.toEntity(producto, userId, hospitalId);
        return ProductoDboMapper.toDomain(productoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        productoJpaRepository.deleteById(uuid);
    }
}
