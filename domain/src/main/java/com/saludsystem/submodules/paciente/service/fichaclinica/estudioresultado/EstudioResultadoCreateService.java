package com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.paciente.port.repository.EstudioResultadoRepository;

public class EstudioResultadoCreateService {

    private final EstudioResultadoRepository estudioResultadoRepository;

    public EstudioResultadoCreateService(EstudioResultadoRepository estudioResultadoRepository) {
        this.estudioResultadoRepository = estudioResultadoRepository;
    }

    public EstudioResultado execute(EstudioResultado estudioResultado) {

        return estudioResultadoRepository.save(estudioResultado);

    }

}
