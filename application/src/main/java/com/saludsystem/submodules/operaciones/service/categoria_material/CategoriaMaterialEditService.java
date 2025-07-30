package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarCategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

import java.util.UUID;

public class CategoriaMaterialEditService {

    private final CategoriaMaterialRepository categoriaMaterialRepository;

    public CategoriaMaterialEditService(CategoriaMaterialRepository categoriaMaterialRepository) {
        this.categoriaMaterialRepository = categoriaMaterialRepository;
    }

    public CategoriaMaterial execute(UUID uuid, ActualizarCategoriaMatDTO dto) {

        var updateCatMaterial = CategoriaMaterialMapper.fromUpdateDto(uuid, dto);

        return categoriaMaterialRepository.update(uuid, updateCatMaterial);

    }

}
