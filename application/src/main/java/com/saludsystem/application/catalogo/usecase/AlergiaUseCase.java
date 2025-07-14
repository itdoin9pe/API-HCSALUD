package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.Alergia;
import com.saludsystem.domain.catalogo.port.in.service.AlergiaService;
import com.saludsystem.domain.catalogo.port.out.repository.AlergiaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlergiaUseCase implements AlergiaService {

    private final AlergiaRepositoryPort alergiaRepositoryPort;

    public AlergiaUseCase(AlergiaRepositoryPort alergiaRepositoryPort) {
        this.alergiaRepositoryPort = alergiaRepositoryPort;
    }

    @Override
    public Alergia save(Alergia alergia) {
        return alergiaRepositoryPort.save(alergia);
    }

    @Override
    public Alergia update(UUID id, Alergia alergia) {
        return alergiaRepositoryPort.update(id, alergia);
    }

    @Override
    public void delete(UUID id) {
        alergiaRepositoryPort.delete(id);
    }

    @Override
    public Alergia getById(UUID id) {
        return alergiaRepositoryPort.findById(id);
    }

    @Override
    public List<Alergia> getAll(UUID hospitalId, int page, int rows) {
        return alergiaRepositoryPort.findAll(hospitalId, page, rows);
    }
}