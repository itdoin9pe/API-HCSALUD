package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;

import java.util.UUID;

public class ClinicaDboMapper {

    public static SysSaludEntity toEntity(SysSalud model, UUID hospitalId) {

        SysSaludEntity entity = new SysSaludEntity();
        entity.setHospitalId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setDireccion(model.getDireccion());
        entity.setCelular(model.getCelular());
        entity.setEmail(model.getEmail());
        entity.setRuc(model.getRuc());
        entity.setFecha(model.getFecha());
        entity.setFoto(model.getFoto());
        entity.setEstado(model.getEstado());
        entity.setHospitalId(hospitalId);

        return entity;

    }

    public static SysSalud toDomain(SysSaludEntity entity) {

        return new SysSalud(entity.getHospitalId(), entity.getNombre(), entity.getDireccion(), entity.getCelular(),
                entity.getEmail(), entity.getRuc(), entity.getFecha(), entity.getFoto(),
                entity.getEstado(), entity.getHospitalId());

    }

}
