package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.Medicamento;
import com.saludsystem.domain.catalogo.port.in.service.MedicamentoService;
import com.saludsystem.domain.catalogo.port.out.repository.MedicamentoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicamentoUseCase implements MedicamentoService {

    private final MedicamentoRepositoryPort medicamentoRepositoryPort;

    public MedicamentoUseCase(MedicamentoRepositoryPort medicamentoRepositoryPort) {
        this.medicamentoRepositoryPort = medicamentoRepositoryPort;
    }

    @Override
    public Medicamento save(Medicamento medicamento) {
        return medicamentoRepositoryPort.save(medicamento);
    }

    @Override
    public Medicamento update(UUID uuid, Medicamento medicamento) {
        return medicamentoRepositoryPort.update(uuid, medicamento);
    }

    @Override
    public void delete(UUID uuid) {
        medicamentoRepositoryPort.delete(uuid);
    }

    @Override
    public Medicamento getById(UUID uuid) {
        return medicamentoRepositoryPort.findById(uuid);
    }

    @Override
    public List<Medicamento> getAll(UUID hospitalId, int page, int rows) {
        return medicamentoRepositoryPort.findAll(hospitalId, page, rows);
    }
}
