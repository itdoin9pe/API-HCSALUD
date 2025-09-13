package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExploracionFisicaDTO
{
	private UUID pacienteExploracionId;
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