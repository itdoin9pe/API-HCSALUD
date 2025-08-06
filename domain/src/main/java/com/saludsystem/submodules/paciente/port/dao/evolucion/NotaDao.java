package com.saludsystem.submodules.paciente.port.dao.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

import java.util.List;
import java.util.UUID;

public interface NotaDao {
    Nota save(Nota tipoCitado);
    Nota update(Long id, Nota tipoCitado);
    void delete(Long id);
    Nota getById(Long id);
    List<Nota> getAll(UUID hospitalId, int page, int rows);
}