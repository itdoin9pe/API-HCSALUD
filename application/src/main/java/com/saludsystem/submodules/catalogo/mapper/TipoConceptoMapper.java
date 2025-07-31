package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoConceptoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoConceptoEditCommand;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;

import java.util.UUID;

public class TipoConceptoMapper {

    public TipoConcepto fromCreateDto(TipoConceptoCreateCommand dto) {
        return new TipoConcepto(null, dto.getNombre(), dto.getEstado());
    }

    public TipoConcepto fromUpdateDto(UUID uuid, TipoConceptoEditCommand dto) {
        return new TipoConcepto(uuid, dto.getNombre(), dto.getEstado());
    }

    public TipoConceptoDTO toDto(TipoConcepto model) {
        return new TipoConceptoDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}
