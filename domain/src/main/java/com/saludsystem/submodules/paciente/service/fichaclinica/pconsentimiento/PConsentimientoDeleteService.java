package com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento;

import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;
import com.saludsystem.submodules.paciente.port.repository.PConsentimientoRepository;

import java.util.UUID;

public class PConsentimientoDeleteService {

    private final PConsentimientoRepository pConsentimientoRepository;
    private final PConsentimientoDao pConsentimientoDao;

    public PConsentimientoDeleteService(PConsentimientoRepository pConsentimientoRepository, PConsentimientoDao pConsentimientoDao) {
        this.pConsentimientoRepository = pConsentimientoRepository;
        this.pConsentimientoDao = pConsentimientoDao;
    }

    public void execute(UUID uuid) {

        var pacienteConsentimiento = pConsentimientoDao.getById(uuid);

        if (pacienteConsentimiento.getEstado() != null && pacienteConsentimiento.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un consentimiento de paciente desactivado");

        }

        pConsentimientoRepository.delete(uuid);

    }

}
