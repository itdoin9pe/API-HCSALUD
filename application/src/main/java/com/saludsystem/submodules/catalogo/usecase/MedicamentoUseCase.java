package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicamentoUseCase implements MedicamentoDao {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoUseCase(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public Medicamento save(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public Medicamento update(UUID uuid, Medicamento medicamento) {
        return medicamentoRepository.update(uuid, medicamento);
    }

    @Override
    public void delete(UUID uuid) {
        medicamentoRepository.delete(uuid);
    }

    @Override
    public Medicamento getById(UUID uuid) {
        return medicamentoRepository.findById(uuid);
    }

    @Override
    public List<Medicamento> getAll(UUID hospitalId, int page, int rows) {
        return medicamentoRepository.findAll(hospitalId, page, rows);
    }
}
