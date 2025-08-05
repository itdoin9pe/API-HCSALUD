package com.saludsystem.submodules.configuracion.service.clinica;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.model.constant.ClinicaConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SysSaludRepository;

import java.util.UUID;

public class ClinicaEditService {

    private final SysSaludDao sysSaludDao;
    private final SysSaludRepository sysSaludRepository;

    public ClinicaEditService(SysSaludDao sysSaludDao, SysSaludRepository sysSaludRepository) {
        this.sysSaludDao = sysSaludDao;
        this.sysSaludRepository = sysSaludRepository;
    }

    public SysSalud execute(UUID uuid, SysSalud sysSalud) {

        var currentCli = sysSaludDao.getById(uuid);

        if (currentCli == null) {
            throw new IllegalArgumentException(ClinicaConstant.ID_NOT_FOUND);
        }

        if (currentCli.getEstado() != null && currentCli.getEstado() == 0) {

            throw new IllegalStateException("La clinica ya se encuentra desactivada");

        }

        return sysSaludRepository.update(uuid, sysSalud);

    }

}
