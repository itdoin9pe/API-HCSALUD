package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoConceptoListHandler {

    private final TipoConceptoDao tipoConceptoDao;
    private final TipoConceptoMapper tipoConceptoMapper;

    public TipoConceptoListHandler(TipoConceptoDao tipoConceptoDao, TipoConceptoMapper tipoConceptoMapper) {
        this.tipoConceptoDao = tipoConceptoDao;
        this.tipoConceptoMapper = tipoConceptoMapper;
    }

    public List<TipoConceptoDTO> execute() {

        List<TipoConcepto> tipoConceptoList = tipoConceptoDao.getList();

        return tipoConceptoList.stream()
                .map(tipoConceptoMapper::toDto)
                .toList();

    }

}
