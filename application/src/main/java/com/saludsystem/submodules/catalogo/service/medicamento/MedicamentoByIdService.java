package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;

import java.util.UUID;

public class MedicamentoByIdService {

    private final MedicamentoDao medicamentoDao;

    public MedicamentoByIdService(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public MedicamentoDTO execute(UUID uuid) {
        return MedicamentoMapper.toDto(medicamentoDao.getById(uuid));
    }
}
