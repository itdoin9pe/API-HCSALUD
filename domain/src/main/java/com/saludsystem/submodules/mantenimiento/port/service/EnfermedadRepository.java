package com.saludsystem.submodules.mantenimiento.port.service;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;

import java.util.List;
import java.util.UUID;

public interface EnfermedadRepository {

    Enfermedad save(Enfermedad enfermedad);
    Enfermedad update(UUID uuid, Enfermedad enfermedad);
    void delete(UUID uuid);
    Enfermedad getById(UUID uuid);
    List<Enfermedad> getAll(UUID hospitalId, int page, int rows);

    //List<EnfermedadDTO> getEnfermedadFiltradosPorRol();

}