package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

public class CategoriaCreateService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaCreateService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria execute(CategoriaCreateCommand dto) {
        var categoriaToCreate = CategoriaMapper.fromCreateDto(dto);
        return categoriaRepository.save(categoriaToCreate);
    }
}
