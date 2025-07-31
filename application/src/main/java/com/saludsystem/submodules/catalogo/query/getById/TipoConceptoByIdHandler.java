package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.constant.TipoConceptoConstant;
import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoByIdHandler {

    private final TipoConceptoDao tipoConceptoDao;
    private final TipoConceptoMapper tipoConceptoMapper;

    public TipoConceptoByIdHandler(TipoConceptoDao tipoConceptoDao, TipoConceptoMapper tipoConceptoMapper) {
        this.tipoConceptoDao = tipoConceptoDao;
        this.tipoConceptoMapper = tipoConceptoMapper;
    }

    public TipoConceptoDTO execute(UUID uuid) {

        var tipoConcepto = tipoConceptoDao.getById(uuid);

        if (tipoConcepto == null) {

            throw new IllegalArgumentException(TipoConceptoConstant.INVALID_ID);

        }

        return tipoConceptoMapper.toDto(tipoConcepto);

    }

}
