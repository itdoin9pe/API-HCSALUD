package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.TipoConcepto;
import com.saludsystem.domain.catalogo.port.in.service.TipoConceptoService;
import com.saludsystem.domain.catalogo.port.out.repository.TipoConceptoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoConceptoUseCase implements TipoConceptoService {

    private final TipoConceptoRepositoryPort tipoConceptoRepositoryPort;

    public TipoConceptoUseCase(TipoConceptoRepositoryPort tipoConceptoRepositoryPort) {
        this.tipoConceptoRepositoryPort = tipoConceptoRepositoryPort;
    }

    @Override
    public TipoConcepto save(TipoConcepto tipoConcepto) {
        return tipoConceptoRepositoryPort.save(tipoConcepto);
    }

    @Override
    public TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto) {
        return tipoConceptoRepositoryPort.update(uuid, tipoConcepto);
    }

    @Override
    public void delete(UUID uuid) {
        tipoConceptoRepositoryPort.delete(uuid);
    }

    @Override
    public TipoConcepto getById(UUID uuid) {
        return tipoConceptoRepositoryPort.findById(uuid);
    }

    @Override
    public List<TipoConcepto> getAll(UUID hospitalId, int page, int rows) {
        return tipoConceptoRepositoryPort.findAll(hospitalId, page, rows);
    }
}
