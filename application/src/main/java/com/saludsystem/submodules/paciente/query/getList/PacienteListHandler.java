package com.saludsystem.submodules.paciente.query.getList;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteListHandler {

    private final PacienteDao pacienteDao;
    private final PacienteMapper pacienteMapper;

    public PacienteListHandler(PacienteDao pacienteDao, PacienteMapper pacienteMapper) {
        this.pacienteDao = pacienteDao;
        this.pacienteMapper = pacienteMapper;
    }

    public List<PacienteDTO> execute() {

        List<Paciente> pacienteList = pacienteDao.getList();

        return pacienteList.stream()
                .map(pacienteMapper::toDto)
                .toList();

    }

}
