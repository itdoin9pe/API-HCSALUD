package com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExploracionFisicaEditCommand extends BaseDTO
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
