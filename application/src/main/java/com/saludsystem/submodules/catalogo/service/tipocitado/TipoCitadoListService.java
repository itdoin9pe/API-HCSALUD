package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;

import java.util.List;

public class TipoCitadoListService {

    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoListService(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public List<TipoCitadoDTO> execute() {
        return tipoCitadoDao.getList()
                .stream().map(TipoCitadoMapper::toDto)
                .toList();
    }
}
