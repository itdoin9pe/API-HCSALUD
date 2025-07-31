package com.saludsystem.submodules.cita.query;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaByIdHandler {

    private final CitaDao citaDao;
    private final CitaMapper citaMapper;

    public CitaByIdHandler(CitaDao citaDao, CitaMapper citaMapper) {
        this.citaDao = citaDao;
        this.citaMapper = citaMapper;
    }

    public CitaDTO execute(UUID uuid) {

        var cita = citaDao.getById(uuid);

        if (cita == null) {

            throw new IllegalArgumentException(CitaConstant.INVALID_ID);

        }

        return citaMapper.toDto(cita);

    }

}