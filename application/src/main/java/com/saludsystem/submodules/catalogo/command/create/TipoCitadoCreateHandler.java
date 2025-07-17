package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

@Component
public class TipoCitadoCreateHandler {

    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoCreateHandler(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public void execute(CrearTipoCitadoDTO dto) {
        tipoCitadoDao.save(TipoCitadoMapper.formCreatoDto(dto));
    }
}
