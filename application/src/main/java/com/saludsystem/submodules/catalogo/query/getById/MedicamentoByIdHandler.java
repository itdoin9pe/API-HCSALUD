package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.constant.MedicamentoConstant;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoByIdHandler {

    private final MedicamentoDao medicamentoDao;
    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoByIdHandler(MedicamentoDao medicamentoDao, MedicamentoMapper medicamentoMapper) {
        this.medicamentoDao = medicamentoDao;
        this.medicamentoMapper = medicamentoMapper;
    }

    public MedicamentoDTO execute(UUID uuid) {

        var medicamento = medicamentoDao.getById(uuid);

        if (medicamento == null) {

            throw new IllegalArgumentException(MedicamentoConstant.INVALID_ID);

        }

        return medicamentoMapper.toDto(medicamento);

    }

}