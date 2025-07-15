package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.in.service.EspecialidadService;
import com.saludsystem.submodules.catalogo.port.out.repository.EspecialidadRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EspecialidadUseCase implements EspecialidadService {

    private final EspecialidadRepositoryPort especialidadRepositoryPort;

    public EspecialidadUseCase(EspecialidadRepositoryPort especialidadRepositoryPort) {
        this.especialidadRepositoryPort = especialidadRepositoryPort;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepositoryPort.save(especialidad);
    }

    @Override
    public Especialidad update(UUID uuid, Especialidad especialidad) {
        return especialidadRepositoryPort.update(uuid, especialidad);
    }

    @Override
    public void delete(UUID uuid) {
        especialidadRepositoryPort.delete(uuid);
    }

    @Override
    public Especialidad getById(UUID uuid) {
        return especialidadRepositoryPort.findById(uuid);
    }

    /*
    @Override
    public List<Especialidad> getAll() {
        return especialidadRepositoryPort.findAll();
    }*/

    @Override
    public List<Especialidad> getAll(UUID hospitalId, int page, int rows) {
        return especialidadRepositoryPort.findAll(hospitalId, page, rows);
    }
}