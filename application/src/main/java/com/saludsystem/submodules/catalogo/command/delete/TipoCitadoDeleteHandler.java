package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoDeleteHandler {

    public final TipoCitadoDao tipoCitadoDao;

    public TipoCitadoDeleteHandler(TipoCitadoDao tipoCitadoDao) {
        this.tipoCitadoDao = tipoCitadoDao;
    }

    public void execute(UUID uuid) {
        tipoCitadoDao.delete(uuid);
    }
}