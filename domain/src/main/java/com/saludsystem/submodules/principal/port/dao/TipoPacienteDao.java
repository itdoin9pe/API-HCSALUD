package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.TipoPaciente;

import java.util.List;

public interface TipoPacienteDao {

    TipoPaciente getById(Long id);
    List<TipoPaciente> getList();

}