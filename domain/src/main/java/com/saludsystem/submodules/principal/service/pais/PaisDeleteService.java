package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisDeleteService {

    private final PaisRepository paisRepository;
    private final PaisDao paisDao;

    public PaisDeleteService(PaisRepository paisRepository, PaisDao paisDao) {
        this.paisRepository = paisRepository;
        this.paisDao = paisDao;
    }

    public void execute(Integer id) {

        var pais = paisDao.getById(id);

        if (pais.getOrden() != null && pais.getOrden() == 0) {
            throw new IllegalStateException("No se puede eliminar un pais fuera del limite standard");
        }

        paisRepository.delete(id);

    }

}
