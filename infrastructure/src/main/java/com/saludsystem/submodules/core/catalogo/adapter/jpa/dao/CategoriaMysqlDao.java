package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.CategoriaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.CategoriaDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaMysqlDao implements CategoriaRepository {

    private final CategoriaJpaRepository categoriaJpaRepository;

    public CategoriaMysqlDao(CategoriaJpaRepository categoriaJpaRepository) {
        this.categoriaJpaRepository = categoriaJpaRepository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity entity = CategoriaDboMapper.toEntity(categoria);
        return CategoriaDboMapper.toDomain(categoriaJpaRepository.save(entity));
    }

    @Override
    public Categoria update(UUID uuid, Categoria categoria) {
        CategoriaEntity entity = CategoriaDboMapper.toEntity(categoria);
        return CategoriaDboMapper.toDomain(categoriaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        categoriaJpaRepository.deleteById(uuid);
    }

    @Override
    public Categoria findById(UUID uuid) {
        return categoriaJpaRepository.findById(uuid).map(CategoriaDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Categoria> findAll(UUID hospitalId, int page, int rows) {
        return categoriaJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(CategoriaDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return categoriaJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}
