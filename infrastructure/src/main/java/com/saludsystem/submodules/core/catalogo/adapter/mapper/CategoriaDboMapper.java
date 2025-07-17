package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;

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