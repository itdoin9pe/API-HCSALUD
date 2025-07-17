package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoByIdHandler {
    public final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoByIdHandler(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public TipoConceptoDTO execute(UUID uuid) {
        TipoConcepto model = tipoConceptoDao.getById(uuid);
        return TipoConceptoMapper.toDto(model);
    }
}
