package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;

import java.util.UUID;

public class TipoCitadoByIdService {

    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoByIdService(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public TipoCitadoDTO execute(UUID uuid) {
        return TipoCitadoMapper.toDto(tipoCitadoDao.getById(uuid));
    }
}