package com.saludsystem.submodules.paciente.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Diagnostico {
	private UUID id;
	private UUID pacienteId;
	private String enfermedadId;
	private LocalDate fecha;
	private String descripcion;

	public Diagnostico(UUID id, UUID pacienteId, String enfermedad, LocalDate fecha, String descripcion) {
		this.id=id;
		this.pacienteId=pacienteId;
		this.enfermedadId=enfermedad;
		this.fecha=fecha;
		this.descripcion=descripcion;
	}
}