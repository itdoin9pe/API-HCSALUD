package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoByIdHandler {
    private final MedicamentoDao medicamentoDao;

    public MedicamentoByIdHandler(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public MedicamentoDTO execute(UUID uuid) {
        Medicamento model = medicamentoDao.getById(uuid);
        return MedicamentoMapper.toDto(model);
    }
}