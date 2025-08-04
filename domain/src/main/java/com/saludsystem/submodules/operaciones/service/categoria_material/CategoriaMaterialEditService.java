package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

import java.util.UUID;

public class CategoriaMaterialEditService {

    private final CategoriaMaterialDao categoriaMaterialDao;
    private final CategoriaMaterialRepository categoriaMaterialRepository;

    public CategoriaMaterialEditService(CategoriaMaterialDao categoriaMaterialDao, CategoriaMaterialRepository categoriaMaterialRepository) {
        this.categoriaMaterialDao = categoriaMaterialDao;
        this.categoriaMaterialRepository = categoriaMaterialRepository;
    }

    public CategoriaMaterial execute(UUID uuid, CategoriaMaterial categoriaMaterial) {

        var currentCatMaterial = categoriaMaterialDao.getById(uuid);

        if (currentCatMaterial.getEstado() != null && currentCatMaterial.getEstado() == 0) {

            throw new IllegalStateException("La categoria de mateiral ya se encuentra desactivada");

        }

        return categoriaMaterialRepository.update(uuid, categoriaMaterial);

    }

}
