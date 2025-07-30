package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoConceptoEditCommand;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;

import java.util.UUID;

public class TipoConceptoEditService {

    private final TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoEditService(TipoConceptoRepository tipoConceptoRepository) {
        this.tipoConceptoRepository = tipoConceptoRepository;
    }

    public TipoConcepto execute(UUID uuid, TipoConceptoEditCommand dto) {
        var update = TipoConceptoMapper.fromUpdateDto(uuid, dto);
        return tipoConceptoRepository.update(uuid, update);
    }

}
