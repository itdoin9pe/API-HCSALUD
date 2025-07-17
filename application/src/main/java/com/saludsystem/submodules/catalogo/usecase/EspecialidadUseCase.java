package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EspecialidadUseCase {

    /*
    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadDao especialidadDao;

    public EspecialidadUseCase(EspecialidadRepository especialidadRepository, EspecialidadDao especialidadDao) {
        this.especialidadRepository = especialidadRepository;
        this.especialidadDao = especialidadDao;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad update(UUID uuid, Especialidad especialidad) {
        return especialidadRepository.update(uuid, especialidad);
    }

    @Override
    public void delete(UUID uuid) {
        especialidadRepository.delete(uuid);
    }

    @Override
    public Especialidad getById(UUID uuid) {
        return especialidadDao.getById(uuid);
    }

    @Override
    public ListResponse<Especialidad> getAll(UUID hospitalId, int page, int rows) {
        return especialidadDao.getAll(hospitalId, page, rows);
    }

    @Override
    public List<Especialidad> getList() {
        return especialidadDao.getList();
    }

     */
}