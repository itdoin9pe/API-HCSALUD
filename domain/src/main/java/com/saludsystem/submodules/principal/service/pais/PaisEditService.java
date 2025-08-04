package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.model.constant.PaisConstant;
import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisEditService {

    private final PaisDao paisDao;
    private final PaisRepository paisRepository;

    public PaisEditService(PaisDao paisDao, PaisRepository paisRepository) {
        this.paisDao = paisDao;
        this.paisRepository = paisRepository;
    }

    public Pais execute(Integer id, Pais pais) {

        var currentPais = paisDao.getById(id);

        if (currentPais == null) {
            throw new IllegalArgumentException(PaisConstant.ID_NOT_FOUND);
        }

        if (currentPais.getOrden() != null && currentPais.getOrden() == 0) {
            throw new IllegalStateException("El pais ya se encuntra desactivada");
        }

        return paisRepository.update(id, pais);

    }

}
