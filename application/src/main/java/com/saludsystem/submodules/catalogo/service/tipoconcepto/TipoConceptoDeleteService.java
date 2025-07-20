package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;

import java.util.UUID;

public class TipoConceptoDeleteService {

    private final TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoDeleteService(TipoConceptoRepository tipoConceptoRepository) {
        this.tipoConceptoRepository = tipoConceptoRepository;
    }

    public void execute(UUID uuid) {
        tipoConceptoRepository.delete(uuid);
    }

}