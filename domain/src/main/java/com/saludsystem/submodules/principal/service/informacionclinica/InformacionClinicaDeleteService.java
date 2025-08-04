package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

import java.util.UUID;

public class InformacionClinicaDeleteService {

    private final InformacionClinicaRepository informacionClinicaRepository;
    private final InformacionClinicaDao informacionClinicaDao;

    public InformacionClinicaDeleteService(InformacionClinicaRepository informacionClinicaRepository, InformacionClinicaDao informacionClinicaDao) {
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.informacionClinicaDao = informacionClinicaDao;
    }

    public void execute(UUID uuid) {

        var infoClinica = informacionClinicaDao.getById(uuid);

        if (infoClinica.getEstado() != null && infoClinica.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar la info clinica ya desactivada");
        }

        informacionClinicaRepository.delete(uuid);

    }

}
