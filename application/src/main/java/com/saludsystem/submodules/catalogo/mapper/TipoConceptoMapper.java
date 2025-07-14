package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.submodules.catalogo.model.TipoConcepto;

import java.util.UUID;

public class TipoConceptoMapper {

    public static TipoConcepto fromCreateDto(CrearTipoConceptoDTO dto) {
        return new TipoConcepto(null, dto.getNombre(), dto.getEstado());
    }

    public static TipoConcepto fromUpdateDto(UUID uuid, ActualizarTipoConceptoDTO dto) {
        return new TipoConcepto(uuid, dto.getNombre(), dto.getEstado());
    }

    public static TipoConceptoDTO toDto(TipoConcepto model) {
        return new TipoConceptoDTO(model.getId(), model.getNombre(), model.getEstado());
    }
}
