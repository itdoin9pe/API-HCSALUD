package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaUseCase implements CategoriaDao {

    private final CategoriaRepository categoriaRepository;

    public CategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(UUID uuid, Categoria categoria) {
        return categoriaRepository.update(uuid, categoria);
    }

    @Override
    public void delete(UUID uuid) {
        categoriaRepository.delete(uuid);
    }

    @Override
    public Categoria getById(UUID uuid) {
        return categoriaRepository.findById(uuid);
    }

    @Override
    public List<Categoria> getAll(UUID hospitalId, int page, int rows) {
        return categoriaRepository.findAll(hospitalId, page, rows);
    }
}
