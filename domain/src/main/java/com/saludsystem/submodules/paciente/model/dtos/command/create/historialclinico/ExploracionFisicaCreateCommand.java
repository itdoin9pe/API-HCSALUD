package com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExploracionFisicaCreateCommand
{
	private UUID pacienteId;
	private String presionArterial;
	private String pulso;
	private String temperatura;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private String peso;
	private String talla;
	private String masa;
	private String examenClinico;
	private String complementoExamen;
}