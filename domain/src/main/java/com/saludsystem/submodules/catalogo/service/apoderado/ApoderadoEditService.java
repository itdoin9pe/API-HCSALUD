package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;

import java.util.UUID;

public class ApoderadoEditService {

    private final ApoderadoDao apoderadoDao;
    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoEditService(ApoderadoDao apoderadoDao, ApoderadoRepository apoderadoRepository) {
        this.apoderadoDao = apoderadoDao;
        this.apoderadoRepository = apoderadoRepository;
    }

    public Apoderado execute(UUID uuid, Apoderado apoderado) {
        var currentApoderado = apoderadoDao.getById(uuid);
        if (currentApoderado.getEstado() != null && currentApoderado.getEstado() == 0) {
            throw new IllegalStateException("El registro ya se encuentra desactivado");
        }
        currentApoderado.actualizarNombre(apoderado.getNombre());
        currentApoderado.actualizarNroDocumento(apoderado.getNroDocumento());
        currentApoderado.actualizarDireccion(apoderado.getDireccion());
        currentApoderado.actualizarTelefono(apoderado.getTelefono());
        currentApoderado.actualizarEstado(apoderado.getEstado());
        return apoderadoRepository.update(uuid, currentApoderado);

    }
}
