package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoConceptoUseCase implements TipoConceptoDao {

    private final TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoUseCase(TipoConceptoRepository tipoConceptoRepository) {
        this.tipoConceptoRepository = tipoConceptoRepository;
    }

    @Override
    public TipoConcepto save(TipoConcepto tipoConcepto) {
        return tipoConceptoRepository.save(tipoConcepto);
    }

    @Override
    public TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto) {
        return tipoConceptoRepository.update(uuid, tipoConcepto);
    }

    @Override
    public void delete(UUID uuid) {
        tipoConceptoRepository.delete(uuid);
    }

    @Override
    public TipoConcepto getById(UUID uuid) {
        return tipoConceptoRepository.findById(uuid);
    }

    @Override
    public List<TipoConcepto> getAll(UUID hospitalId, int page, int rows) {
        return tipoConceptoRepository.findAll(hospitalId, page, rows);
    }
}
