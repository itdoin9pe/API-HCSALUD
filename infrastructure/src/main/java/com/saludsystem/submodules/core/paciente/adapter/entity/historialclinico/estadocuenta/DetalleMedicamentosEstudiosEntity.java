package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta;

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
@Table(name = "pacientes_detalles_medicamentos_estudios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DetalleMedicamentosEstudiosEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_detalle", nullable = false)
	private UUID pec_detalleMedicamentoId;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private PacienteEntity pacienteEntity;

	@ManyToOne
	@JoinColumn(name = "id_estado_cuenta", nullable = false)
	private EstadoCuentaEntity estadoCuentaEntity;

	@Column(name = "tipo", nullable = false)
	private String tipo; // "MEDICAMENTO" o "ESTUDIO"

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "costo_unitario", nullable = false)
	private Double costoUnitario;

	@Column(name = "total_costo", nullable = false)
	private Double totalCosto;
}