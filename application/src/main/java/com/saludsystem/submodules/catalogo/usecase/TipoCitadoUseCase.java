package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoCitadoUseCase implements TipoCitadoDao {

    private final TipoCitadoRepository tipoCitadoRepository;

    public TipoCitadoUseCase(TipoCitadoRepository tipoCitadoRepository) {
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    @Override
    public TipoCitado save(TipoCitado tipoCitado) {
        return tipoCitadoRepository.save(tipoCitado);
    }

    @Override
    public TipoCitado update(UUID uuid, TipoCitado tipoCitado) {
        return tipoCitadoRepository.update(uuid, tipoCitado);
    }

    @Override
    public void delete(UUID uuid) {
        tipoCitadoRepository.delete(uuid);
    }

    @Override
    public TipoCitado getById(UUID uuid) {
        return tipoCitadoRepository.findById(uuid);
    }

    @Override
    public List<TipoCitado> getAll(UUID hospitalId, int page, int rows) {
        return tipoCitadoRepository.findAll(hospitalId, page, rows);
    }
}
