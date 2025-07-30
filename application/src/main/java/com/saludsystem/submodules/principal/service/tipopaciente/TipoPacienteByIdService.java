package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;

public class TipoPacienteByIdService {

    private final TipoPacienteDao tipoPacienteDao;

    public TipoPacienteByIdService(TipoPacienteDao tipoPacienteDao) {
        this.tipoPacienteDao = tipoPacienteDao;
    }

    public TipoPacienteDTO execute(Long id) {
        return TipoPacienteMapper.toDto(tipoPacienteDao.getById(id));
    }
}
