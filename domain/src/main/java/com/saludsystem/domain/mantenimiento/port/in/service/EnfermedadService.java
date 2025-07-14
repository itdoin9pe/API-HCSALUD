package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.Enfermedad;

import java.util.List;
import java.util.UUID;

public interface EnfermedadService {

    Enfermedad save(Enfermedad enfermedad);
    Enfermedad update(UUID uuid, Enfermedad enfermedad);
    void delete(UUID uuid);
    Enfermedad getById(UUID uuid);
    List<Enfermedad> getAll(UUID hospitalId, int page, int rows);

    //List<EnfermedadDTO> getEnfermedadFiltradosPorRol();

}