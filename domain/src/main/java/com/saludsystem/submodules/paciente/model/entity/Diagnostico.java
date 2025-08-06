package com.saludsystem.submodules.paciente.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Diagnostico {
	
	private UUID id;
	private UUID pacienteId;
	private String enfermedadId;
	private LocalDate fecha;
	private String descripcion;
	
}