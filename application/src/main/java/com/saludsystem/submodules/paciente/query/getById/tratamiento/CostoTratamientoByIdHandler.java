package com.saludsystem.submodules.paciente.query.getById.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.CostoTratamientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CostoTratamientoByIdHandler {

    private final CostoTratamientoDao costoTratamientoDao;
    private final CostoTratamientoMapper costoTratamientoMapper;

    public CostoTratamientoByIdHandler(CostoTratamientoDao costoTratamientoDao, CostoTratamientoMapper costoTratamientoMapper) {
        this.costoTratamientoDao = costoTratamientoDao;
        this.costoTratamientoMapper = costoTratamientoMapper;
    }

    public CostoTratamientoDTO execute(UUID uuid) {

        var costoTratamiento = costoTratamientoDao.getById(uuid);

        if (costoTratamiento == null) {

            throw new IllegalArgumentException(CostoTratamientoConstant.INVALID_ID);

        }

       return costoTratamientoMapper.toDto(costoTratamiento);

    }

}
