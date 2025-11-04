package com.saludsystem.submodules.paciente.model.dtos.command.create;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteCreateCommand
{
	private String tipoDocumentoId;

	private String numeroDocumento;

	private String apellidos;

	private String nombres;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;

	@Schema(example = "1", type = "integer")
	private Integer edad;

	@Schema(example = "0", type = "integer")
	private Integer estado;

	private String ocupacion;

	private String direccion;

	@Schema(example = "1", type = "integer")
	private Integer paisId;

	private String departamento;
	private String provincia;
	private String distrito;

	private String ubigeo;

	@Schema(example = "0", type = "integer")
	private Long tipoPacienteId;

	private String estadoCivil;

	private String sexo;

	private String nombreContacto;

	private String tipoHistoria;

	private UUID aseguradoraId;

	private UUID empresaId;

	@Email(message = "El email debe ser válido")
	private String email;

	private String fotoPaciente;

	private String titulo;

	private String observacion;

	private UUID informacionClinicaId;

	private UUID estudioId;

	private UUID sedeId;

	private String celular;
}