package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;

import java.util.List;

public class TipoConceptoListService {

    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoListService(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public List<TipoConceptoDTO> execute() {
        return tipoConceptoDao.getList().stream().map(TipoConceptoMapper::toDto).toList();
    }
}
