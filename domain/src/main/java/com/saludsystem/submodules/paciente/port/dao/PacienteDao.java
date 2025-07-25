package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.Paciente;

import java.util.List;

import java.util.UUID;

public interface PacienteDao {

    Paciente save(Paciente paciente);
    Paciente update(UUID uuid, Paciente paciente);
    void delete(UUID uuid);
    Paciente getById(UUID uuid);
    List<Paciente> getAll(UUID hospitalId, int page, int rows);

}