package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

import java.util.UUID;

public class MarcaEditService {

    private final MarcaDao marcaDao;
    private final MarcaRepository marcaRepository;

    public MarcaEditService(MarcaDao marcaDao, MarcaRepository marcaRepository) {
        this.marcaDao = marcaDao;
        this.marcaRepository = marcaRepository;
    }

    public Marca execute(UUID uuid, Marca marca) {

        var currentMarca = marcaDao.getById(uuid);

        if (currentMarca.getEstado() != null && currentMarca.getEstado() == 0) {

            throw new IllegalStateException("La marca ya se encuentra desactivada");

        }

        return marcaRepository.update(uuid, marca);

    }

}
