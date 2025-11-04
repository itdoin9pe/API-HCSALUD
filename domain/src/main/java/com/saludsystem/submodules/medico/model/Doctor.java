package com.saludsystem.submodules.medico.model;

import java.time.LocalDate;

import com.saludsystem.submodules.configuracion.model.vo.usuario.NumeroDocumento;
import com.saludsystem.submodules.medico.model.vo.Apellido;
import com.saludsystem.submodules.medico.model.vo.Celular;
import com.saludsystem.submodules.medico.model.vo.Colegiatura;
import com.saludsystem.submodules.medico.model.vo.Correo;
import com.saludsystem.submodules.medico.model.vo.Direccion;
import com.saludsystem.submodules.medico.model.vo.DoctorId;
import com.saludsystem.submodules.medico.model.vo.EspecialidadId;
import com.saludsystem.submodules.medico.model.vo.Nombre;
import com.saludsystem.submodules.medico.model.vo.Rne;
import com.saludsystem.submodules.medico.model.vo.Telefono;
import com.saludsystem.submodules.medico.model.vo.TipoDocumento;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Doctor
{
	private DoctorId id;
	private TipoDocumento tipoDocumento;
	private NumeroDocumento numeroDocumento;
	private Apellido apellidos;
	private Nombre nombres;
	private Direccion direccion;
	private Correo correo;
	private String abreviatura;
	private Rne rne;
	private LocalDate fechaNacimiento;
	private Celular celular;
	private Telefono telefono;
	private String sexo;
	private EspecialidadId especialidadId;
	private Colegiatura colegiatura;
	private String color;
	private Integer estado;
	private String fotoDoctor;
	private String fotoFirma;

	public Doctor(
		DoctorId id,
		TipoDocumento tipoDocumento,
		NumeroDocumento numeroDocumento,
		Apellido apellidos,
		Nombre nombres,
		Direccion direccion,
		Correo correo,
		String abreviatura,
		Rne rne,
		LocalDate fechaNacimiento,
		Celular celular,
		Telefono telefono,
		String sexo,
		EspecialidadId especialidadId,
		Colegiatura colegiatura,
		String color,
		Integer estado,
		String fotoDoctor,
		String fotoFirma)
	{
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.direccion = direccion;
		this.correo = correo;
		this.abreviatura = abreviatura;
		this.rne = rne;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.telefono = telefono;
		this.sexo = sexo;
		this.especialidadId = especialidadId;
		this.colegiatura = colegiatura;
		this.color = color;
		this.estado = estado;
		this.fotoDoctor = fotoDoctor;
		this.fotoFirma = fotoFirma;
	}
}