package com.saludsystem.submodules.configuracion.query.getList;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicaListHandler {

    private final SysSaludDao sysSaludDao;
    private final ClinicaMapper clinicaMapper;

    public ClinicaListHandler(SysSaludDao sysSaludDao, ClinicaMapper clinicaMapper) {
        this.sysSaludDao = sysSaludDao;
        this.clinicaMapper = clinicaMapper;
    }

    public List<ClinicaDTO> execute() {

        List<SysSalud> sysSaludList = sysSaludDao.getList();

        return sysSaludList.stream()
                .map(clinicaMapper::toDto)
                .toList();

    }

}
