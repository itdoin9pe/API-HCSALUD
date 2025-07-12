package com.saludsystem.infrastructure.adapter.mapper.catalogo;

import com.saludsystem.domain.catalogo.model.Consentimiento;
import com.saludsystem.infrastructure.adapter.entity.catalogo.ConsentimientoEntity;

public class ConsentimientoDboMapper {

    public static ConsentimientoEntity toEntity(Consentimiento model) {
        ConsentimientoEntity e = new ConsentimientoEntity();
        e.setTexto(model.getTexto());
        e.setNombre(model.getNombre());
        e.setObservacion(model.getObservacion());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Consentimiento toDomain(ConsentimientoEntity e) {
        return new Consentimiento(e.getConsentimientoId(),
                e.getNombre(),
                e.getObservacion(),
                e.getEstado(),
                e.getTexto());
    }

}