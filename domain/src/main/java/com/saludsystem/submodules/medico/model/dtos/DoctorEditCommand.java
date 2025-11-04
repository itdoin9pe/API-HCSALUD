package com.saludsystem.submodules.medico.model.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEditCommand extends BaseDTO
{
	private UUID doctorId;
	private String tipoDocumento;
	private String numeroDocumento;
	private String apellidos;
	private String nombres;
	private String direccion;
	private String correo;
	private String abreviatura;
	private String rne;
	private LocalDate fechaNacimiento;
	private String celular;
	private String telefono;
	private String sexo;
	private UUID especialidadId;
	private String colegiatura;
	private String color;
	
	@Schema(example = "0")
	private Integer estado;
	
	private String fotoDoctor;
	private String fotoFirma;
}