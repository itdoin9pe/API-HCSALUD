package com.saludsystem.submodules.core.paciente.adapter.entity;

import java.time.LocalDateTime;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes_estudios_resultados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EstudioResultadoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente_estudio_resultado", nullable = false)
	private Long Id;

	@Column(name = "estudio_resultado_reporte", nullable = false)
	private String reporteTexto;

	@Column(name = "estudio_resultado_imagen", nullable = false)
	private String urlImg;

	@OneToOne
	@JoinColumn(name = "id_paciente_estudio")
	private EstudioMedicoEntity estudioMedicoEntity;

	private LocalDateTime createdAt;
}