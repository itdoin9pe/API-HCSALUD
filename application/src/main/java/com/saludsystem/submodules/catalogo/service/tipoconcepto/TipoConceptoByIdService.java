package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;

import java.util.UUID;

public class TipoConceptoByIdService {

    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoByIdService(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public TipoConceptoDTO execute(UUID uuid) {
        return TipoConceptoMapper.toDto(tipoConceptoDao.getById(uuid));
    }

}