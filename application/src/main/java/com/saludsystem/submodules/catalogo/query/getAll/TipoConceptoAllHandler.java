package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoConceptoAllHandler {
    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoAllHandler(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public List<TipoConceptoDTO> execute(UUID hospitalId, int page, int rows) {
        List<TipoConcepto> models = tipoConceptoDao.getAll(hospitalId, page, rows);
        return models.stream().map(TipoConceptoMapper::toDto).toList();
    }
}
