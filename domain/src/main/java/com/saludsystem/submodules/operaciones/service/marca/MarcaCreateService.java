package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

public class MarcaCreateService {

    private final MarcaRepository marcaRepository;

    public MarcaCreateService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca execute(Marca marca) {

        return marcaRepository.save(marca);

    }

}
