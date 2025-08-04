package com.saludsystem.submodules.operaciones.service.presentacion;

import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import com.saludsystem.submodules.operaciones.port.repository.PresentacionRepository;

import java.util.UUID;

public class PresentacionDeleteService {

    private final PresentacionRepository presentacionRepository;
    private final PresentacionDao presentacionDao;

    public PresentacionDeleteService(PresentacionRepository presentacionRepository, PresentacionDao presentacionDao) {
        this.presentacionRepository = presentacionRepository;
        this.presentacionDao = presentacionDao;
    }

    public void execute(UUID uuid) {

        var presentacion = presentacionDao.getById(uuid);

        if (presentacion.getEstado() != null && presentacion.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar una presentacion ya desactivada");

        }

        presentacionRepository.delete(uuid);

    }

}
