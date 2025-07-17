package com.saludsystem.submodules.sections.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.AlergiaEntity;

public class AlergiaDboMapper {
    public static AlergiaEntity toEntity(Alergia model) {
        AlergiaEntity entity = new AlergiaEntity();
        entity.setAlergiaId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setEstado(model.getEstado());
        return entity;
    }

    public static Alergia toDomain(AlergiaEntity entity) {
        return new Alergia(entity.getAlergiaId(), entity.getNombre(), entity.getEstado());
    }
}
