package com.saludsystem.infrastructure.adapter.mapper.catalogo;

import com.saludsystem.domain.catalogo.model.Especialidad;
import com.saludsystem.infrastructure.adapter.entity.catalogo.EspecialidadEntity;

public class EspecialidadDboMapper {

    public static EspecialidadEntity toEntity(Especialidad model) {
        EspecialidadEntity e = new EspecialidadEntity();
        e.setDescripcion(model.getDescripcion());
        e.setNombre(model.getNombre());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Especialidad toDomain(EspecialidadEntity e) {
        return new Especialidad(e.getEspecialidadId(),
                e.getDescripcion(),
                e.getNombre(),
                e.getEstado());
    }
}