package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.in.service.CategoriaService;
import com.saludsystem.submodules.catalogo.port.out.repository.CategoriaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaUseCase implements CategoriaService {

    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaUseCase(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepositoryPort.save(categoria);
    }

    @Override
    public Categoria update(UUID uuid, Categoria categoria) {
        return categoriaRepositoryPort.update(uuid, categoria);
    }

    @Override
    public void delete(UUID uuid) {
        categoriaRepositoryPort.delete(uuid);
    }

    @Override
    public Categoria getById(UUID uuid) {
        return categoriaRepositoryPort.findById(uuid);
    }

    @Override
    public List<Categoria> getAll(UUID hospitalId, int page, int rows) {
        return categoriaRepositoryPort.findAll(hospitalId, page, rows);
    }
}
