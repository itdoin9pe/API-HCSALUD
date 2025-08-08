package com.saludsystem.submodules.paciente.query.getById;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteByIdHandler {

    private final PacienteDao pacienteDao;
    private final PacienteMapper pacienteMapper;

    public PacienteByIdHandler(PacienteDao pacienteDao, PacienteMapper pacienteMapper) {
        this.pacienteDao = pacienteDao;
        this.pacienteMapper = pacienteMapper;
    }

    public PacienteDTO execute(UUID uuid) {

        var paciente = pacienteDao.getById(uuid);

        if (paciente == null) {

            throw new IllegalArgumentException(PacienteConstant.INVALID_ID);

        }

        return pacienteMapper.toDto(paciente);

    }

}
