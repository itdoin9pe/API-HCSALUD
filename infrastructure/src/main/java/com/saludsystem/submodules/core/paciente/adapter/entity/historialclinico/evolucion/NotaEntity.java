package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion;

import java.time.LocalDateTime;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

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
@Table(name = "pacientes_evoluciones_notas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class NotaEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evolucion_nota_id")
	private Long id;

	@Column(name = "fecha_nota", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "tipo_nota", nullable = false)
	private String tipo; // "medico" o "enfermeria"

	@Column(name = "contenido_nota", nullable = false)
	private String contenido;

	@ManyToOne
	@JoinColumn(name = "paciente_evolucion_id")
	private EvolucionEntity evolucionEntity;
}