package com.saludsystem.submodules.paciente.query.getList.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AltaMedicaListHandler {

    private final AltaMedicaDao altaMedicaDao;
    private final AltaMedicaMapper altaMedicaMapper;

    public AltaMedicaListHandler(AltaMedicaDao altaMedicaDao, AltaMedicaMapper altaMedicaMapper) {
        this.altaMedicaDao = altaMedicaDao;
        this.altaMedicaMapper = altaMedicaMapper;
    }

    public List<AltaMedicaDTO> execute() {

        List<AltaMedica> altaMedicaList = altaMedicaDao.getList();

        return altaMedicaList.stream()
                .map(altaMedicaMapper::toDto)
                .toList();

    }

}
