package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoConceptoDeleteHandler {
    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoDeleteHandler(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public void execute(UUID uuid) {
        tipoConceptoDao.delete(uuid);
    }
}
