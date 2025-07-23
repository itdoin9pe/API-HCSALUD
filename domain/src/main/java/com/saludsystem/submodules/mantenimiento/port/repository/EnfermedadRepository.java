package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;

import java.util.UUID;

public interface EnfermedadRepository {

    Enfermedad save(Enfermedad enfermedad);
    Enfermedad update(UUID uuid, Enfermedad enfermedad);
    void delete(String id);

    //List<EnfermedadDTO> getEnfermedadFiltradosPorRol();
}