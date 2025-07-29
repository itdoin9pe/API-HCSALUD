package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.model.dtos.post.CrearCategotiaMatDTO;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

public class CategoriaMaterialCreateService {

    private final CategoriaMaterialRepository categoriaMaterialRepository;

    public CategoriaMaterialCreateService(CategoriaMaterialRepository categoriaMaterialRepository) {
        this.categoriaMaterialRepository = categoriaMaterialRepository;
    }

    public CategoriaMaterial execute(CrearCategotiaMatDTO dto) {

        var catMaterial = CategoriaMaterialMapper.fromCreateDto(dto);

        return categoriaMaterialRepository.save(catMaterial);

    }

}
