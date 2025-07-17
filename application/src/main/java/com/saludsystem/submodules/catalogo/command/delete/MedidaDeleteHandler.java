package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaDeleteHandler {
    private final MedidaDao medidaDao;

    public MedidaDeleteHandler(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public void execute(UUID uuid) {
        medidaDao.delete(uuid);
    }
}
