package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoCitadoAllHandler {
    private final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoAllHandler(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public List<TipoCitadoDTO> execute(UUID hospitalId, int page, int rows) {
        List<TipoCitado> models = tipoCitadoDao.getAll(hospitalId, page, rows);
        return models.stream().map(TipoCitadoMapper::toDto).toList();
    }
}
