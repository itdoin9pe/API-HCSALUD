package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

import java.util.UUID;

public class ConsentimientoDeleteService {

    private final ConsentimientoRepository consentimientoRepository;
    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoDeleteService(ConsentimientoRepository consentimientoRepository, ConsentimientoDao consentimientoDao) {
        this.consentimientoRepository = consentimientoRepository;
        this.consentimientoDao = consentimientoDao;
    }

    public void execute(UUID uuid) {

        var consentimiento = consentimientoDao.getById(uuid);

        if (consentimiento.getEstado() != null && consentimiento.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar un consentimiento ya desactivado");
        }

        consentimientoRepository.delete(uuid);

    }

}
