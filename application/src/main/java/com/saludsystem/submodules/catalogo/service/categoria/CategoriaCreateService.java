package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearCategoriaDTO;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

public class CategoriaCreateService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaCreateService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria execute(CrearCategoriaDTO dto) {
        var categoriaToCreate = CategoriaMapper.fromCreateDto(dto);
        return categoriaRepository.save(categoriaToCreate);
    }
}
