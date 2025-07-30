package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;

import java.util.List;

public class TipoPacienteListService {

    private final TipoPacienteDao tipoPacienteDao;

    public TipoPacienteListService(TipoPacienteDao tipoPacienteDao) {
        this.tipoPacienteDao = tipoPacienteDao;
    }

    public List<TipoPacienteDTO> execute() {
        return tipoPacienteDao.getList()
                .stream()
                .map(TipoPacienteMapper::toDto)
                .toList();
    }

}
