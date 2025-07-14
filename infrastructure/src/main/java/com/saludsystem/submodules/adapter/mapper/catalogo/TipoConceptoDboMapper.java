package com.saludsystem.submodules.adapter.mapper.catalogo;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.adapter.entity.catalogo.TipoConceptoEntity;

public class TipoConceptoDboMapper {
    public static TipoConceptoEntity toEntity(TipoConcepto model) {
        TipoConceptoEntity e = new TipoConceptoEntity();
        e.setTipoConceptoId(model.getId());
        e.setNombre(model.getNombre());
        e.setEstado(model.getEstado());
        return e;
    }

    public static TipoConcepto toDomain(TipoConceptoEntity e) {
        return new TipoConcepto(e.getTipoConceptoId(), e.getNombre(), e.getEstado());
    }
}
