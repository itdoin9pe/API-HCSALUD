package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_costos_tratamientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CostoTratamientoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "paciente_costo_tratamiento", nullable = false)
	private UUID pacienteCostoTratamientoId;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_plan_tratamiento", nullable = false)
	private PlanTratamientoEntity planTratamientoEntity;

	@Column(name = "concepto_costo_tratamiento", nullable = false)
	private String concepto;

	@Column(name = "monto_costo_tratamiento", nullable = false)
	private double monto;

	@Column(name = "moneda_costo_tratamiento", nullable = false)
	private String moneda;

	@Column(name = "pagado_costo_tratamiento", nullable = false)
	private boolean pagado;
}