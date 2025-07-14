package com.saludsystem.submodules.adapter.mapper.catalogo;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.adapter.entity.catalogo.MedidaEntity;

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