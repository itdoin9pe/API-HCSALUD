package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CostoTratamiento {
	private UUID pacienteCostoTratamientoId;
	private UUID pacienteId;
	private UUID planTratamientoId;
	private String concepto;
	private double monto;
	private String moneda;
	private boolean pagado;

	public CostoTratamiento(UUID pacienteCostoTratamientoId, UUID pacienteId, UUID planTratamientoId, String concepto,
			double monto, String moneda, boolean pagado) {
		this.pacienteCostoTratamientoId = pacienteCostoTratamientoId;
		this.pacienteId = pacienteId;
		this.planTratamientoId = planTratamientoId;
		this.concepto = concepto;
		this.monto = monto;
		this.moneda = moneda;
		this.pagado = pagado;
	}
}