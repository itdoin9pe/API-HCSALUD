package com.saludsystem.submodules.paciente.query.getList;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoRecetadoListHandler {

    private final MedicamentoRecetadoDao medicamentoRecetadoDao;
    private final MedicamentoRecetadoMapper medicamentoRecetadoMapper;

    public MedicamentoRecetadoListHandler(MedicamentoRecetadoDao medicamentoRecetadoDao, MedicamentoRecetadoMapper medicamentoRecetadoMapper) {
        this.medicamentoRecetadoDao = medicamentoRecetadoDao;
        this.medicamentoRecetadoMapper = medicamentoRecetadoMapper;
    }

    public List<MedicamentoRecetadoDTO> execute() {

        List<MedicamentoRecetado> medicamentoRecetadoList = medicamentoRecetadoDao.getList();

        return medicamentoRecetadoList
                .stream()
                .map(medicamentoRecetadoMapper::toDto)
                .toList();

    }

}
