package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InformacionClinicaListHandler {

    private final InformacionClinicaDao informacionClinicaDao;
    private final InformacionClinicaMapper informacionClinicaMapper;

    public InformacionClinicaListHandler(InformacionClinicaDao informacionClinicaDao, InformacionClinicaMapper informacionClinicaMapper) {
        this.informacionClinicaDao = informacionClinicaDao;
        this.informacionClinicaMapper = informacionClinicaMapper;
    }

    public List<InformacionClinicaDTO> execute() {

        List<InformacionClinica> informacionClinicaList = informacionClinicaDao.getList();

        return informacionClinicaList.stream()
                .map(informacionClinicaMapper::toDto)
                .toList();

    }

}
