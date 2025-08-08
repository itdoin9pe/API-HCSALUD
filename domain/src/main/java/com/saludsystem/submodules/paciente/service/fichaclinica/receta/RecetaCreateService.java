package com.saludsystem.submodules.paciente.service.fichaclinica.receta;

import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.paciente.port.repository.RecetaRepository;

public class RecetaCreateService {

    private final RecetaRepository recetaRepository;

    public RecetaCreateService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public Receta execute(Receta receta) {

        return recetaRepository.save(receta);

    }

}
