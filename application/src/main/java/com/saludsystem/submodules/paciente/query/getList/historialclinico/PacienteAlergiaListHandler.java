package com.saludsystem.submodules.paciente.query.getList.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteAlergiaListHandler {

    private final PacienteAlergiaDao pacienteAlergiaDao;
    private final PacienteAlergiaMapper pacienteAlergiaMapper;

    public PacienteAlergiaListHandler(PacienteAlergiaDao pacienteAlergiaDao, PacienteAlergiaMapper pacienteAlergiaMapper) {
        this.pacienteAlergiaDao = pacienteAlergiaDao;
        this.pacienteAlergiaMapper = pacienteAlergiaMapper;
    }

    public List<PacienteAlergiaDTO> execute() {

        List<PacienteAlergia> pacienteAlergiaList = pacienteAlergiaDao.getList();

        return pacienteAlergiaList.stream()
                .map(pacienteAlergiaMapper::toDto)
                .toList();

    }

}
