package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.CategoriaMatEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.CategoriaMatJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.CategoriaMaterialDboMapper;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMaterialMysqlRepository implements CategoriaMaterialRepository {

    private final CategoriaMatJpaRepository categoriaMatJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CategoriaMaterialMysqlRepository(CategoriaMatJpaRepository categoriaMatJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.categoriaMatJpaRepository = categoriaMatJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public CategoriaMaterial save(CategoriaMaterial categoriaMaterial) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CategoriaMatEntity entity = CategoriaMaterialDboMapper.toEntity(categoriaMaterial, userId, hospitalId);
        return CategoriaMaterialDboMapper.toDomain(categoriaMatJpaRepository.save(entity));
    }

    @Override
    public CategoriaMaterial update(UUID uuid, CategoriaMaterial categoriaMaterial) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CategoriaMatEntity entity = CategoriaMaterialDboMapper.toEntity(categoriaMaterial, userId, hospitalId);
        return CategoriaMaterialDboMapper.toDomain(categoriaMatJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        categoriaMatJpaRepository.deleteById(uuid);
    }

}
