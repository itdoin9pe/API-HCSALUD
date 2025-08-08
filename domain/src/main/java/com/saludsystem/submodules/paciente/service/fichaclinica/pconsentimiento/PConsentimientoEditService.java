package com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento;

import com.saludsystem.submodules.paciente.model.constant.PConsentimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;
import com.saludsystem.submodules.paciente.port.repository.PConsentimientoRepository;

import java.util.UUID;

public class PConsentimientoEditService {

    private final PConsentimientoDao pConsentimientoDao;
    private final PConsentimientoRepository pConsentimientoRepository;

    public PConsentimientoEditService(PConsentimientoDao pConsentimientoDao, PConsentimientoRepository pConsentimientoRepository) {
        this.pConsentimientoDao = pConsentimientoDao;
        this.pConsentimientoRepository = pConsentimientoRepository;
    }

    public PacienteConsentimiento execute(UUID uuid, PacienteConsentimiento pacienteConsentimiento) {

        var currentPacienteConsentimiento = pConsentimientoDao.getById(uuid);

        if (currentPacienteConsentimiento == null ) {

            throw new IllegalArgumentException(PConsentimientoConstant.ID_NOT_FOUND);

        }

        if (currentPacienteConsentimiento.getEstado() != null && currentPacienteConsentimiento.getEstado() == 0) {

            throw new IllegalStateException("El consentimiento de paciente ya se encuentra desactivado");

        }

        return pConsentimientoRepository.update(uuid, pacienteConsentimiento);

    }

}
