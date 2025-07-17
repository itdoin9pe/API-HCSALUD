package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoEditHandler {
    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoEditHandler(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public void execute(UUID uuid, ActualizarTipoConceptoDTO dto) {
        tipoConceptoDao.update(uuid, TipoConceptoMapper.fromUpdateDto(uuid, dto));
    }
}
