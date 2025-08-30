package com.saludsystem.submodules.cita.query;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitaListHandler {

    private final CitaDao citaDao;
    private final CitaMapper citaMapper;

    public CitaListHandler(CitaDao citaDao, CitaMapper citaMapper) {
        this.citaDao = citaDao;
        this.citaMapper = citaMapper;
    }

    public List<CitaDTO> execute() {

        List<Cita> citaList = citaDao.getList();

        return citaList
                .stream()
                .map(citaMapper::toDto)
                .toList();

    }

}
