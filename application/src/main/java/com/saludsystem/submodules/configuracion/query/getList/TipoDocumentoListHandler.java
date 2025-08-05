package com.saludsystem.submodules.configuracion.query.getList;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoDocumentoListHandler {

    private final TipoDocumentoDao tipoDocumentoDao;
    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoListHandler(TipoDocumentoDao tipoDocumentoDao, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoDao = tipoDocumentoDao;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    public List<TipoDocumentoDTO> execute() {

        List<TipoDocumento> tipoDocumentoList = tipoDocumentoDao.getList();

        return tipoDocumentoList.stream()
                .map(tipoDocumentoMapper::toDto)
                .toList();

    }

}
