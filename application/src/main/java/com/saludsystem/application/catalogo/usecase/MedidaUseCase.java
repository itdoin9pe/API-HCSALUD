package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.Medida;
import com.saludsystem.domain.catalogo.port.in.service.MedidaService;
import com.saludsystem.domain.catalogo.port.out.repository.MedidaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedidaUseCase implements MedidaService {

    private final MedidaRepositoryPort medidaRepositoryPort;

    public MedidaUseCase(MedidaRepositoryPort medidaRepositoryPort) {
        this.medidaRepositoryPort = medidaRepositoryPort;
    }

    @Override
    public Medida save(Medida medida) {
        return medidaRepositoryPort.save(medida);
    }

    @Override
    public Medida update(UUID uuid, Medida medida) {
        return medidaRepositoryPort.update(uuid, medida);
    }

    @Override
    public void delete(UUID uuid) {
        medidaRepositoryPort.delete(uuid);
    }

    @Override
    public Medida getById(UUID uuid) {
        return medidaRepositoryPort.findById(uuid);
    }

    @Override
    public List<Medida> getAll(UUID hospitalId, int page, int rows) {
        return medidaRepositoryPort.findAll(hospitalId, page, rows);
    }
}