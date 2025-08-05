package com.saludsystem.submodules.configuracion.query.getAll;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoDocumentoByIdHandler {

    private final TipoDocumentoDao tipoDocumentoDao;
    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoByIdHandler(TipoDocumentoDao tipoDocumentoDao, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoDao = tipoDocumentoDao;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    public TipoDocumentoDTO execute(UUID uuid) {

        var tipoDocumento = tipoDocumentoDao.getById(uuid);

        if (tipoDocumento == null) {

            throw new IllegalArgumentException(TipoDocumentoConstant.ID_NOT_FOUND);

        }

        return tipoDocumentoMapper.toDto(tipoDocumento);

    }

}
