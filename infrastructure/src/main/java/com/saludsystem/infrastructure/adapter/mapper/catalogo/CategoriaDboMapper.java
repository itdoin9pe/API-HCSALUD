package com.saludsystem.infrastructure.adapter.mapper.catalogo;

import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.infrastructure.adapter.entity.catalogo.CategoriaEntity;

public class CategoriaDboMapper {

    public static CategoriaEntity toEntity(Categoria model){
        CategoriaEntity e = new CategoriaEntity();
        e.setCategoriaId(model.getId());
        e.setNombre(model.getNombre());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Categoria toDomain(CategoriaEntity e) {
        return new Categoria(e.getCategoriaId(),
                e.getNombre(),
                e.getEstado());
    }
}