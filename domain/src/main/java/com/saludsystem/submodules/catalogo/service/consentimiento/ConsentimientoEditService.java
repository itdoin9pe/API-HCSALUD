package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

import java.util.UUID;

public class ConsentimientoEditService {

    private final ConsentimientoDao consentimientoDao;
    private final ConsentimientoRepository consentimientoRepository;

    public ConsentimientoEditService(ConsentimientoDao consentimientoDao, ConsentimientoRepository consentimientoRepository) {
        this.consentimientoDao = consentimientoDao;
        this.consentimientoRepository = consentimientoRepository;
    }

    public Consentimiento execute(UUID uuid, Consentimiento model) {

        var currentConsent = consentimientoDao.getById(uuid);

        if (currentConsent.getEstado() != null && currentConsent.getEstado() == 0) {
            throw new IllegalStateException("El consentimiento ya se encuentra desactivado");
        }

        return consentimientoRepository.update(uuid, model);

    }

}