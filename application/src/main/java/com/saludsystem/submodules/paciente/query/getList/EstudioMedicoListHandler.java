package com.saludsystem.submodules.paciente.query.getList;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioMedicoListHandler {

    private final EstudioMedicoDao estudioMedicoDao;
    private final EstudioMedicoMapper estudioMedicoMapper;

    public EstudioMedicoListHandler(EstudioMedicoDao estudioMedicoDao, EstudioMedicoMapper estudioMedicoMapper) {
        this.estudioMedicoDao = estudioMedicoDao;
        this.estudioMedicoMapper = estudioMedicoMapper;
    }

    public List<EstudioMedicoDTO> execute() {

        List<EstudioMedico> estudioMedicoList = estudioMedicoDao.getList();

        return estudioMedicoList.stream()
                .map(estudioMedicoMapper::toDto)
                .toList();

    }

}
