package com.saludsystem.submodules.principal.port.dao;

import java.util.List;

import com.saludsystem.submodules.principal.model.TipoPaciente;

public interface TipoPacienteDao
{
	TipoPaciente getById(Long id);

	List<TipoPaciente> getList();
}