package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoByIdHandler {
    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoByIdHandler(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public TipoCitadoDTO execute(UUID uuid) {
        TipoCitado model = tipoCitadoDao.getById(uuid);
        return TipoCitadoMapper.toDto(model);
    }
}
