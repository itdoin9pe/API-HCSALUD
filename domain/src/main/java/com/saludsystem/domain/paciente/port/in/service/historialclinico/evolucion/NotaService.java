package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.domain.paciente.model.historialclinico.evolucion.Nota;

import java.util.List;
import java.util.UUID;

public interface NotaService {
    Nota save(Nota tipoCitado);
    Nota update(Long id, Nota tipoCitado);
    void delete(Long id);
    Nota getById(Long id);
    List<Nota> getAll(UUID hospitalId, int page, int rows);
}