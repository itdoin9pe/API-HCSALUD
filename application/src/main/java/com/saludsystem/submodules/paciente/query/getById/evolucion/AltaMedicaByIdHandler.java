package com.saludsystem.submodules.paciente.query.getById.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.AltaMedicaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import org.springframework.stereotype.Component;

@Component
public class AltaMedicaByIdHandler {

    private final AltaMedicaDao altaMedicaDao;
    private final AltaMedicaMapper altaMedicaMapper;

    public AltaMedicaByIdHandler(AltaMedicaDao altaMedicaDao, AltaMedicaMapper altaMedicaMapper) {
        this.altaMedicaDao = altaMedicaDao;
        this.altaMedicaMapper = altaMedicaMapper;
    }

    public AltaMedicaDTO execute(Long id) {

        var altaMedica = altaMedicaDao.getById(id);

        if (altaMedica == null) {

            throw new IllegalArgumentException(AltaMedicaConstant.INVALID_ID);

        }

        return altaMedicaMapper.toDto(altaMedica);

    }

}
