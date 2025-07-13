package com.saludsystem.application.catalogo.usecase;

import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
import com.saludsystem.domain.catalogo.port.out.repository.TipoCitadoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoCitadoUseCase implements TipoCitadoService {

    private final TipoCitadoRepositoryPort tipoCitadoRepositoryPort;

    public TipoCitadoUseCase(TipoCitadoRepositoryPort tipoCitadoRepositoryPort) {
        this.tipoCitadoRepositoryPort = tipoCitadoRepositoryPort;
    }

    @Override
    public TipoCitado save(TipoCitado tipoCitado) {
        return tipoCitadoRepositoryPort.save(tipoCitado);
    }

    @Override
    public TipoCitado update(UUID uuid, TipoCitado tipoCitado) {
        return tipoCitadoRepositoryPort.update(uuid, tipoCitado);
    }

    @Override
    public void delete(UUID uuid) {
        tipoCitadoRepositoryPort.delete(uuid);
    }

    @Override
    public TipoCitado getById(UUID uuid) {
        return tipoCitadoRepositoryPort.findById(uuid);
    }

    @Override
    public List<TipoCitado> getAll(UUID hospitalId, int page, int rows) {
        return tipoCitadoRepositoryPort.findAll(hospitalId, page, rows);
    }
}
