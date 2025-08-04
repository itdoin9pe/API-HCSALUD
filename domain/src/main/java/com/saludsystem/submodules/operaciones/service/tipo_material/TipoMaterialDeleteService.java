package com.saludsystem.submodules.operaciones.service.tipo_material;

import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.TipoMaterialRepository;

import java.util.UUID;

public class TipoMaterialDeleteService {

    private final TipoMaterialRepository tipoMaterialRepository;
    private final TipoMaterialDao tipoMaterialDao;

    public TipoMaterialDeleteService(TipoMaterialRepository tipoMaterialRepository, TipoMaterialDao tipoMaterialDao) {
        this.tipoMaterialRepository = tipoMaterialRepository;
        this.tipoMaterialDao = tipoMaterialDao;
    }

    public void execute(UUID uuid) {

        var tipoMaterial = tipoMaterialDao.getById(uuid);

        if (tipoMaterial.getEstado() != null && tipoMaterial.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un tipo de material ya desactivado");

        }

        tipoMaterialRepository.delete(uuid);

    }

}
