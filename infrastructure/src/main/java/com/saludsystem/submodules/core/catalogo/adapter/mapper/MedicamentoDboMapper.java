package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedicamentoEntity;

public class MedicamentoDboMapper {

    public static MedicamentoEntity toEntity(Medicamento model) {
        MedicamentoEntity e = new MedicamentoEntity();
        e.setNombre(model.getNombre());
        e.setFormaFarmaceutica(model.getFormaFarmaceutica());
        e.setConcentracion(model.getConcentracion());
        e.setContenido(model.getContenido());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Medicamento toDomain(MedicamentoEntity e) {
        return new Medicamento(e.getMedicamentoId(),
                e.getNombre(),
                e.getFormaFarmaceutica(),
                e.getConcentracion(),
                e.getContenido(),
                e.getEstado());
    }
}