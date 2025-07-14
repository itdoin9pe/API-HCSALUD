package com.saludsystem.submodules.adapter.repository.catalogo;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.out.repository.MedicamentoRepositoryPort;
import com.saludsystem.submodules.adapter.entity.catalogo.MedicamentoEntity;
import com.saludsystem.submodules.adapter.jparepository.catalogo.MedicamentoJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.MedicamentoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedicamentoRepositoryAdapter implements MedicamentoRepositoryPort {

    private final MedicamentoJpaRepository medicamentoJpaRepository;

    public MedicamentoRepositoryAdapter(MedicamentoJpaRepository medicamentoJpaRepository) {
        this.medicamentoJpaRepository = medicamentoJpaRepository;
        System.out.println("✅ MedicamentoRepositoryAdapter inicializado");
    }

    @Override
    public Medicamento save(Medicamento medicamento) {
        MedicamentoEntity entity = MedicamentoDboMapper.toEntity(medicamento);
        return MedicamentoDboMapper.toDomain(medicamentoJpaRepository.save(entity));
    }

    @Override
    public Medicamento update(UUID uuid, Medicamento medicamento) {
        medicamento.setId(uuid);
        MedicamentoEntity entity = MedicamentoDboMapper.toEntity(medicamento);
        return MedicamentoDboMapper.toDomain(medicamentoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        medicamentoJpaRepository.deleteById(uuid);
    }

    @Override
    public Medicamento findById(UUID uuid) {
        return medicamentoJpaRepository.findById(uuid).map(MedicamentoDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Medicamento> findAll(UUID hospitalId, int page, int rows) {
        return medicamentoJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(MedicamentoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return medicamentoJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}