package com.saludsystem.infrastructure.adapter.catalogo;

import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.domain.catalogo.port.out.repository.CategoriaRepositoryPort;
import com.saludsystem.infrastructure.jparepository.catalogo.CategoriaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaRepositoryAdapter implements CategoriaRepositoryPort {

    private final CategoriaJpaRepository categoriaJpaRepository;

    public CategoriaRepositoryAdapter(CategoriaJpaRepository categoriaJpaRepository) {
        this.categoriaJpaRepository = categoriaJpaRepository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria update(UUID uuid, Categoria categoria) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Categoria findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Categoria> findAll(UUID hospitalId, int page, int rows) {
        return List.of();
    }
}
