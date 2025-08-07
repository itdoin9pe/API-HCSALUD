package com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado;

import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioResultadoRepository;

public class EstudioResultadoDeleteService {

    private final EstudioResultadoRepository estudioResultadoRepository;
    private final EstudioResultadoDao estudioResultadoDao;

    public EstudioResultadoDeleteService(EstudioResultadoRepository estudioResultadoRepository, EstudioResultadoDao estudioResultadoDao) {
        this.estudioResultadoRepository = estudioResultadoRepository;
        this.estudioResultadoDao = estudioResultadoDao;
    }

    public void execute(Long id) {

        var estudioResultado = estudioResultadoDao.getById(id);

        if (estudioResultado.getId() != null && estudioResultado.getId() == 0) {

            throw new IllegalStateException("No se puede eliminar un resultado de estudio inexistente");

        }

        estudioResultadoRepository.delete(id);

    }

}
