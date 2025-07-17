package com.saludsystem.submodules.sections.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.MedidaEntity;

public class MedidaDboMapper {

    public static MedidaEntity toEntity(Medida model) {
        MedidaEntity e = new MedidaEntity();
        e.setNombre(model.getNombre());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Medida toDomain(MedidaEntity e) {
        return new Medida(e.getMedidaId(),
                e.getNombre(),
                e.getEstado());
    }
}