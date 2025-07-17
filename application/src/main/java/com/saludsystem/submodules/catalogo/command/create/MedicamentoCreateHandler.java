package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoCreateHandler {
    private final MedicamentoDao medicamentoDao;

    public MedicamentoCreateHandler(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public void execute(CrearMedicamentoDTO dto){
        medicamentoDao.save(MedicamentoMapper.fromCreateDto(dto));
    }
}