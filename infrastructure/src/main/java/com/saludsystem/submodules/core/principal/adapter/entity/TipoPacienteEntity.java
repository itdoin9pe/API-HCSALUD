package com.saludsystem.submodules.core.principal.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_paciente")
public class TipoPacienteEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipoPaciente", nullable = false)
	public Long tipoPacienteId;

	@NotBlank(message = "This fild can't be empty")
	@Column(name = "nombre_tipoPaciente", nullable = false)
	public String nombre;
}
