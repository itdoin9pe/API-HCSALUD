package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

@Component
public class TipoConceptoCreateHandler {

    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoCreateHandler(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public void execute(CrearTipoConceptoDTO dto) {
        tipoConceptoDao.save(TipoConceptoMapper.fromCreateDto(dto));
    }
}
