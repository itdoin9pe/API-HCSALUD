package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;

import java.util.List;

public class MedicamentoListService {

    private final MedicamentoDao medicamentoDao;

    public MedicamentoListService(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public List<MedicamentoCreateCommand> execute() {
        return medicamentoDao.getList().stream().map(MedicamentoMapper::toDto).toList();
    }
}
