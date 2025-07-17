package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoDeleteHandler {
    private final MedicamentoDao medicamentoDao;

    public MedicamentoDeleteHandler(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public void execute(UUID uuid){
        medicamentoDao.delete(uuid);
    }
}