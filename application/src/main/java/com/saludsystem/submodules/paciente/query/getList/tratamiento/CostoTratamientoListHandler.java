package com.saludsystem.submodules.paciente.query.getList.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CostoTratamientoListHandler {

    private final CostoTratamientoDao costoTratamientoDao;
    private final CostoTratamientoMapper costoTratamientoMapper;

    public CostoTratamientoListHandler(CostoTratamientoDao costoTratamientoDao, CostoTratamientoMapper costoTratamientoMapper) {
        this.costoTratamientoDao = costoTratamientoDao;
        this.costoTratamientoMapper = costoTratamientoMapper;
    }

    public List<CostoTratamientoDTO> execute() {

        List<CostoTratamiento> costoTratamientoList = costoTratamientoDao.getList();

        return costoTratamientoList
                .stream()
                .map(costoTratamientoMapper::toDto)
                .toList();

    }

}
