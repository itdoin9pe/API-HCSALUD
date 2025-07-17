package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedidaUseCase implements MedidaDao {

    private final MedidaRepository medidaRepository;

    public MedidaUseCase(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    @Override
    public Medida save(Medida medida) {
        return medidaRepository.save(medida);
    }

    @Override
    public Medida update(UUID uuid, Medida medida) {
        return medidaRepository.update(uuid, medida);
    }

    @Override
    public void delete(UUID uuid) {
        medidaRepository.delete(uuid);
    }

    @Override
    public Medida getById(UUID uuid) {
        return medidaRepository.findById(uuid);
    }

    @Override
    public List<Medida> getAll(UUID hospitalId, int page, int rows) {
        return medidaRepository.findAll(hospitalId, page, rows);
    }
}