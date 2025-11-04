package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ExploracionFisica {
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

	public ExploracionFisica(UUID pacienteExploracionId, UUID pacienteId, String presionArterial, String pulso,
			String temperatura, String frecuenciaCardiaca, String frecuenciaRespiratoria, String peso, String talla,
			String masa, String examenClinico, String complementoExamen) {
		this.pacienteExploracionId = pacienteExploracionId;
		this.pacienteId = pacienteId;
		this.presionArterial = presionArterial;
		this.pulso = pulso;
		this.temperatura = temperatura;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.peso = peso;
		this.talla = talla;
		this.masa = masa;
		this.examenClinico = examenClinico;
		this.complementoExamen = complementoExamen;
	}
}