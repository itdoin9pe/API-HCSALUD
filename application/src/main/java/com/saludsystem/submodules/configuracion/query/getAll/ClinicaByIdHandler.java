package com.saludsystem.submodules.configuracion.query.getAll;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.model.constant.ClinicaConstant;
import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClinicaByIdHandler {

    private final SysSaludDao sysSaludDao;
    private final ClinicaMapper clinicaMapper;

    public ClinicaByIdHandler(SysSaludDao sysSaludDao, ClinicaMapper clinicaMapper) {
        this.sysSaludDao = sysSaludDao;
        this.clinicaMapper = clinicaMapper;
    }

    public ClinicaDTO execute(UUID uuid) {

        var clinica = sysSaludDao.getById(uuid);

        if (clinica == null) {

            throw new IllegalArgumentException(ClinicaConstant.INVALID_ID);

        }

        return clinicaMapper.toDto(clinica);

    }

}
