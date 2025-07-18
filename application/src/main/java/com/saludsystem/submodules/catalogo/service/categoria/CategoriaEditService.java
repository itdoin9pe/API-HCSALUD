package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;

import java.util.UUID;

public class CategoriaEditService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaEditService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria execute(UUID uuid, ActualizarCategoriaDTO dto) {
        var updateToSave = CategoriaMapper.fromUpdateDto(uuid, dto);
        return categoriaRepository.update(uuid, updateToSave);
    }
}
