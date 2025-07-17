package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoEditHandler {
    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoEditHandler(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public void execute(UUID uuid, ActualizarTipoCitadoDTO dto) {
        tipoCitadoDao.update(uuid, TipoCitadoMapper.fromUpdateDto(uuid, dto));
    }
}