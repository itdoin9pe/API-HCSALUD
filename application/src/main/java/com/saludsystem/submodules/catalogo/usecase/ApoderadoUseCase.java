package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApoderadoUseCase implements ApoderadoDao {

    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoUseCase(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public Apoderado update(UUID uuid, Apoderado apoderado) {
        return apoderadoRepository.update(uuid, apoderado);
    }

    @Override
    public void delete(UUID uuid) {
        apoderadoRepository.delete(uuid);
    }

    @Override
    public Apoderado getById(UUID uuid) {
        return apoderadoRepository.findById(uuid);
    }

    @Override
    public List<Apoderado> getAll(UUID hospitalId, int page, int rows) {
        return apoderadoRepository.findAll(hospitalId, page, rows);
    }
}