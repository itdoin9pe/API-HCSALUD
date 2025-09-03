package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;

import java.util.UUID;

public class TipoConceptoEditService {

    private final TipoConceptoDao tipoConceptoDao;
    private final TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoEditService(TipoConceptoDao tipoConceptoDao, TipoConceptoRepository tipoConceptoRepository) {
        this.tipoConceptoDao = tipoConceptoDao;
        this.tipoConceptoRepository = tipoConceptoRepository;
    }

    public TipoConcepto execute(UUID uuid, TipoConcepto model) {
        var currentTipoConcepto = tipoConceptoDao.getById(uuid);
        if (currentTipoConcepto.getEstado() != null && currentTipoConcepto.getEstado() == 0) {
            throw new IllegalStateException("El tipo de concepto ya se encuentra desactivado");
        }
        currentTipoConcepto.actualizarNombre(model.getNombre());
        currentTipoConcepto.actualizarEstado(model.getEstado());
        return tipoConceptoRepository.update(uuid, currentTipoConcepto);
    }
}
