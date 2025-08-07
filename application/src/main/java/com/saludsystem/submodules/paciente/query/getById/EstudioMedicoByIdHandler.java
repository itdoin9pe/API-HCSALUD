package com.saludsystem.submodules.paciente.query.getById;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioMedicoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import org.springframework.stereotype.Component;

@Component
public class EstudioMedicoByIdHandler {

    private final EstudioMedicoDao estudioMedicoDao;
    private final EstudioMedicoMapper estudioMedicoMapper;

    public EstudioMedicoByIdHandler(EstudioMedicoDao estudioMedicoDao, EstudioMedicoMapper estudioMedicoMapper) {
        this.estudioMedicoDao = estudioMedicoDao;
        this.estudioMedicoMapper = estudioMedicoMapper;
    }

    public EstudioMedicoDTO execute(Long id) {

        var estudioMedico = estudioMedicoDao.getById(id);

        if (estudioMedico == null) {

            throw new IllegalArgumentException(EstudioMedicoConstant.INVALID_ID);

        }

        return estudioMedicoMapper.toDto(estudioMedico);

    }

}
