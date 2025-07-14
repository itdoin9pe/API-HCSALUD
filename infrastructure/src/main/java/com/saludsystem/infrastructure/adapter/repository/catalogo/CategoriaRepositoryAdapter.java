package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.domain.catalogo.port.out.repository.CategoriaRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.CategoriaEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.CategoriaJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.CategoriaDboMapper;
import org.springframework.data.domain.PageRequest;
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
