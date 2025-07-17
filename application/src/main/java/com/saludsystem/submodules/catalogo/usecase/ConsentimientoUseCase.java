package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsentimientoUseCase implements ConsentimientoDao {

    private final ConsentimientoRepository consentimientoRepository;

    public ConsentimientoUseCase(ConsentimientoRepository consentimientoRepository) {
        this.consentimientoRepository = consentimientoRepository;
    }

    @Override
    public Consentimiento save(Consentimiento consentimiento) {
        return consentimientoRepository.save(consentimiento);
    }

    @Override
    public Consentimiento update(UUID uuid, Consentimiento consentimiento) {
        return consentimientoRepository.update(uuid, consentimiento);
    }

    @Override
    public void delete(UUID uuid) {
        consentimientoRepository.delete(uuid);
    }

    @Override
    public Consentimiento getById(UUID uuid) {
        return consentimientoRepository.findById(uuid);
    }

    @Override
    public List<Consentimiento> getAll(UUID hospitalId, int page, int rows) {
        return consentimientoRepository.findAll(hospitalId, page, rows);
    }
}