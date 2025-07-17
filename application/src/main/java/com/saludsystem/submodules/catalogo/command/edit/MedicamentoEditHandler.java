package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarMedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoEditHandler {
    private final MedicamentoDao medicamentoDao;

    public MedicamentoEditHandler(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public void execute(UUID uuid, ActualizarMedicamentoDTO dto){
        medicamentoDao.update(uuid, MedicamentoMapper.fromUpdateDto(uuid, dto));
    }
}