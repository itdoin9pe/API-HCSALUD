package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.paciente.model.Paciente;

import java.util.List;

import java.util.UUID;

public interface PacienteService {

    Paciente save(Paciente paciente);
    Paciente update(UUID uuid, Paciente paciente);
    void delete(UUID uuid);
    Paciente getById(UUID uuid);
    List<Paciente> getAll(UUID hospitalId, int page, int rows);

}