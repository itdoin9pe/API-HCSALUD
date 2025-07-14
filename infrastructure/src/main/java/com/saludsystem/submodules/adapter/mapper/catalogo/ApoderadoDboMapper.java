package com.saludsystem.submodules.adapter.mapper.catalogo;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.adapter.entity.catalogo.ApoderadoEntity;

public class ApoderadoDboMapper {
    public static ApoderadoEntity toEntity(Apoderado model) {
        ApoderadoEntity e = new ApoderadoEntity();
        e.setNombre(model.getNombre());
        e.setDireccion(model.getDireccion());
        e.setTelefono(model.getTelefono());
        e.setNroDocumento(model.getNroDocumento());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Apoderado toDomain(ApoderadoEntity e) {
        return new Apoderado(e.getApoderadoId(),
                e.getNombre(),
                e.getNroDocumento(),
                e.getTelefono(),
                e.getDireccion(),
                e.getEstado());
    }
}