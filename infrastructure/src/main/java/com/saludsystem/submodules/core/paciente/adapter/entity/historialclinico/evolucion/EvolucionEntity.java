package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_evoluciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EvolucionEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "paciente_evolucion_id", nullable = false)
	private UUID pacienteEvolucionId;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity pacienteEntity;

	@Column(name = "fecha_inicio")
	private LocalDateTime fechaInicio;

	private Boolean finalizada = false;

	@OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
	private List<NotaEntity> notas;

	@OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
	private List<CambioCondicionEntity> cambios;

	@OneToOne(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
	private AltaMedicaEntity altaMedica;
}