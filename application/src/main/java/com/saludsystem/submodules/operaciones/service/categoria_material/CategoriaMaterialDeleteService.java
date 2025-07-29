package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

import java.util.UUID;

public class CategoriaMaterialDeleteService {

    private final CategoriaMaterialRepository categoriaMaterialRepository;

    public CategoriaMaterialDeleteService(CategoriaMaterialRepository categoriaMaterialRepository) {
        this.categoriaMaterialRepository = categoriaMaterialRepository;
    }

    public void execute(UUID uuid) {
        categoriaMaterialRepository.delete(uuid);
    }

}
