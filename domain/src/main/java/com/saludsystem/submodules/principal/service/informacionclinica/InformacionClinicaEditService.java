package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.constant.InformacionClinicaConstant;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

import java.util.UUID;

public class InformacionClinicaEditService {

    private final InformacionClinicaDao informacionClinicaDao;
    private final InformacionClinicaRepository informacionClinicaRepository;

    public InformacionClinicaEditService(InformacionClinicaDao informacionClinicaDao, InformacionClinicaRepository informacionClinicaRepository) {
        this.informacionClinicaDao = informacionClinicaDao;
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    public InformacionClinica execute(UUID uuid, InformacionClinica informacionClinica) {

        var currentInfoClinica = informacionClinicaDao.getById(uuid);

        if (currentInfoClinica == null) {
            throw new IllegalArgumentException(InformacionClinicaConstant.ID_NOT_FOUND);
        }

        if (currentInfoClinica.getEstado() != null && currentInfoClinica.getEstado() == 0) {
            throw new IllegalStateException("La informacion clinica ya se encuentra inactiva");
        }

        return informacionClinicaRepository.update(uuid, informacionClinica);

    }

}
