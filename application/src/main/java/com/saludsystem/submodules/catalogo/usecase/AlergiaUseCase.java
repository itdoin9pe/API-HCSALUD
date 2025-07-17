package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlergiaUseCase implements AlergiaDao {

    private final AlergiaRepository alergiaRepository;

    public AlergiaUseCase(AlergiaRepository alergiaRepository) {
        this.alergiaRepository = alergiaRepository;
    }

    @Override
    public Alergia save(Alergia alergia) {
        return alergiaRepository.save(alergia);
    }

    @Override
    public Alergia update(UUID id, Alergia alergia) {
        return alergiaRepository.update(id, alergia);
    }

    @Override
    public void delete(UUID id) {
        alergiaRepository.delete(id);
    }

    @Override
    public Alergia getById(UUID id) {
        return alergiaRepository.findById(id);
    }

    @Override
    public List<Alergia> getAll(UUID hospitalId, int page, int rows) {
        return alergiaRepository.findAll(hospitalId, page, rows);
    }
}