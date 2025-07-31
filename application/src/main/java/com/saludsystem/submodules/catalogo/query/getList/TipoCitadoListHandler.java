package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoCitadoListHandler {

    private final TipoCitadoDao tipoCitadoDao;
    private final TipoCitadoMapper tipoCitadoMapper;

    public TipoCitadoListHandler(TipoCitadoDao tipoCitadoDao, TipoCitadoMapper tipoCitadoMapper) {
        this.tipoCitadoDao = tipoCitadoDao;
        this.tipoCitadoMapper = tipoCitadoMapper;
    }

    public List<TipoCitadoDTO> execute() {

        List<TipoCitado> tipoCitadoList = tipoCitadoDao.getList();

        return tipoCitadoList.stream()
                .map(tipoCitadoMapper::toDto)
                .toList();

    }

}