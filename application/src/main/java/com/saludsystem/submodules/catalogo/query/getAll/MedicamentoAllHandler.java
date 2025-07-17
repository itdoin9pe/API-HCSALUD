package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedicamentoAllHandler {
    private final MedicamentoDao medicamentoDao;

    public MedicamentoAllHandler(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public List<MedicamentoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Medicamento> models = medicamentoDao.getAll(hospitalId, page, rows);
        return models.stream().map(MedicamentoMapper::toDto).toList();
    }
}