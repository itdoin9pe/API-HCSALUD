package com.saludsystem.submodules.paciente.model.dtos.get;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DiagnosticoDTO {

	public DiagnosticoDTO(UUID id, UUID pacienteId, String enfermedadId, LocalDate fecha, String descripcion) {
		// TODO Auto-generated constructor stub
		this.setPacienteDiagnosticoId(id);
		this.setPacienteId(pacienteId);
		this.setEnfermedadId(enfermedadId);
		this.setFecha(fecha);
		this.setDescripcion(descripcion);
	}

	private UUID pacienteDiagnosticoId;

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

    
}