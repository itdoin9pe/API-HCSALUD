package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;

import java.util.List;

public class InformacionClinicaListService {

    private final InformacionClinicaDao informacionClinicaDao;

    public InformacionClinicaListService(InformacionClinicaDao informacionClinicaDao) {
        this.informacionClinicaDao = informacionClinicaDao;
    }

    public List<InformacionClinicaDTO> execute() {
        return informacionClinicaDao.getList()
                .stream()
                .map(InformacionClinicaMapper::toDto)
                .toList();
    }

}
