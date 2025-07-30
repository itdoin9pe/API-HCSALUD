package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.dto.command.CrearTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;

public class TipoConceptoCreateService {

    private final TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoCreateService(TipoConceptoRepository tipoConceptoRepository) {
        this.tipoConceptoRepository = tipoConceptoRepository;
    }

    public TipoConcepto execute(CrearTipoConceptoDTO dto) {
        var create = TipoConceptoMapper.fromCreateDto(dto);
        return tipoConceptoRepository.save(create);
    }
}
