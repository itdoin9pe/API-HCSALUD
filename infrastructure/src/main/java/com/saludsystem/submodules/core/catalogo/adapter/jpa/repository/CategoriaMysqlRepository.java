package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.CategoriaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.CategoriaDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMysqlRepository implements CategoriaRepository {

    private final CategoriaJpaRepository categoriaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CategoriaMysqlRepository(CategoriaJpaRepository categoriaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.categoriaJpaRepository = categoriaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Categoria save(Categoria categoria) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CategoriaEntity entity = CategoriaDboMapper.toEntity(categoria, userId, hospitalId);
        return CategoriaDboMapper.toDomain(categoriaJpaRepository.save(entity));
    }

    @Override
    public Categoria update(UUID uuid, Categoria categoria) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CategoriaEntity entity = CategoriaDboMapper.toEntity(categoria, userId, hospitalId);
        return CategoriaDboMapper.toDomain(categoriaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        categoriaJpaRepository.deleteById(uuid);
    }
}
