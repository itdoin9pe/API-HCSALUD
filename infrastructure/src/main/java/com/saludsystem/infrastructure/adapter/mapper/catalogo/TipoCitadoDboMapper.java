package com.saludsystem.infrastructure.adapter.mapper.catalogo;

import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.infrastructure.adapter.entity.catalogo.TipoCitadoEntity;

public class TipoCitadoDboMapper {

    public static TipoCitadoEntity toEntity(TipoCitado model) {
        TipoCitadoEntity e = new TipoCitadoEntity();
        e.setTipoCitadoId(model.getId());
        e.setNombre(model.getNombre());
        e.setColor(model.getColor());
        e.setEstado(model.getEstado());
        return e;
    }

    public static TipoCitado toDomain(TipoCitadoEntity e) {
        return new TipoCitado(e.getTipoCitadoId(), e.getNombre(),
                e.getColor(), e.getEstado());
    }
}