package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.Apoderado;
import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
import com.saludsystem.domain.catalogo.port.out.repository.ApoderadoRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ApoderadoUseCase implements ApoderadoService {

    private final ApoderadoRepositoryPort apoderadoRepositoryPort;

    public ApoderadoUseCase(ApoderadoRepositoryPort apoderadoRepositoryPort) {
        this.apoderadoRepositoryPort = apoderadoRepositoryPort;
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        return apoderadoRepositoryPort.save(apoderado);
    }

    @Override
    public Apoderado update(UUID uuid, Apoderado apoderado) {
        return apoderadoRepositoryPort.update(uuid, apoderado);
    }

    @Override
    public void delete(UUID uuid) {
        apoderadoRepositoryPort.delete(uuid);
    }

    @Override
    public Apoderado getById(UUID uuid) {
        return apoderadoRepositoryPort.findById(uuid);
    }

    @Override
    public List<Apoderado> getAll(UUID hospitalId, int page, int rows) {
        return apoderadoRepositoryPort.findAll(hospitalId, page, rows);
    }
}