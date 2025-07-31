package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoListHandler {

    private final MedicamentoDao medicamentoDao;
    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoListHandler(MedicamentoDao medicamentoDao, MedicamentoMapper medicamentoMapper) {
        this.medicamentoDao = medicamentoDao;
        this.medicamentoMapper = medicamentoMapper;
    }

    public List<MedicamentoDTO> execute() {

        List<Medicamento> medicamentoList = medicamentoDao.getList();

        return medicamentoList.stream()
                .map(medicamentoMapper::toDto)
                .toList();

    }

}
