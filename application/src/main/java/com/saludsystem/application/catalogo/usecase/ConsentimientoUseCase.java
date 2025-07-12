package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.Consentimiento;
import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
import com.saludsystem.domain.catalogo.port.out.repository.ConsentimientoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsentimientoUseCase implements ConsentimientoService {

    private final ConsentimientoRepositoryPort consentimientoRepositoryPort;

    public ConsentimientoUseCase(ConsentimientoRepositoryPort consentimientoRepositoryPort) {
        this.consentimientoRepositoryPort = consentimientoRepositoryPort;
    }

    @Override
    public Consentimiento save(Consentimiento consentimiento) {
        return consentimientoRepositoryPort.save(consentimiento);
    }

    @Override
    public Consentimiento update(UUID uuid, Consentimiento consentimiento) {
        return consentimientoRepositoryPort.update(uuid, consentimiento);
    }

    @Override
    public void delete(UUID uuid) {
        consentimientoRepositoryPort.delete(uuid);
    }

    @Override
    public Consentimiento getById(UUID uuid) {
        return consentimientoRepositoryPort.findById(uuid);
    }

    @Override
    public List<Consentimiento> getAll(UUID hospitalId, int page, int rows) {
        return consentimientoRepositoryPort.findAll(hospitalId, page, rows);
    }
}