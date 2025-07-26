package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;

import java.util.UUID;

public class InformacionClinicaByIdService {

    private final InformacionClinicaDao informacionClinicaDao;

    public InformacionClinicaByIdService(InformacionClinicaDao informacionClinicaDao) {
        this.informacionClinicaDao = informacionClinicaDao;
    }

    public InformacionClinicaDTO execute(UUID uuid) {
        return InformacionClinicaMapper.toDto(informacionClinicaDao.getById(uuid));
    }

}
