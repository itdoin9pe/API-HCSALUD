package com.saludsystem.submodules.paciente.model.entity;

import com.saludsystem.submodules.paciente.model.vo.paciente.ApellidoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.CelularPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.DepartamentoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.DireccionPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.DistritoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.EdadPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.EmailPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.EstadoCivilPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.EstadoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.FNacimientoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.FotoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdAseguradoraPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdEmpresaPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdEstudioPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdPaisPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdSedePaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.IdTipoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.InformacionClinicaPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.NombreContactoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.NombrePaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.NumeroDocPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.ObservacionPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.OcupacionPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.ProvinciaPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.SexoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.TipoDocumentoPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.TipoHistoriaPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.TituloPaciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.UbigeoPaciente;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Paciente
{
	private IdPaciente pacienteId;
	private TipoDocumentoPaciente tipoDocumento;
	private NumeroDocPaciente numeroDocumento;
	private ApellidoPaciente apellidos;
	private NombrePaciente nombres;
	private FNacimientoPaciente fechaNacimiento;
	private EdadPaciente edad;
	private EstadoPaciente estado;
	private OcupacionPaciente ocupacion;
	private DireccionPaciente direccion;
	private IdPaisPaciente paisId;
	private DepartamentoPaciente departamento;
	private ProvinciaPaciente provincia;
	private DistritoPaciente distrito;
	private UbigeoPaciente ubigeo;
	private IdTipoPaciente tipoPacienteId;
	private EstadoCivilPaciente estadoCivil;
	private SexoPaciente sexo;
	private NombreContactoPaciente nombreContacto;
	private TipoHistoriaPaciente tipoHistoria;
	private IdAseguradoraPaciente aseguradoraId;
	private IdEmpresaPaciente empresaId;
	private EmailPaciente email;
	private FotoPaciente fotoPaciente;
	private TituloPaciente titulo;
	private ObservacionPaciente observacion;
	private InformacionClinicaPaciente informacionClinicaId;
	private IdEstudioPaciente estudioId;
	private IdSedePaciente sedeId;
	private CelularPaciente celular;

	public Paciente(
		IdPaciente pacienteId,
		TipoDocumentoPaciente tipoDocumento,
		NumeroDocPaciente numeroDocumento,
		ApellidoPaciente apellidos,
		NombrePaciente nombres,
		FNacimientoPaciente fechaNacimiento,
		EdadPaciente edad,
		EstadoPaciente estado,
		OcupacionPaciente ocupacion,
		DireccionPaciente direccion,
		IdPaisPaciente paisId,
		DepartamentoPaciente departamento,
		ProvinciaPaciente provincia,
		DistritoPaciente distrito,
		UbigeoPaciente ubigeo,
		IdTipoPaciente tipoPacienteId,
		EstadoCivilPaciente estadoCivil,
		SexoPaciente sexo,
		NombreContactoPaciente nombreContacto,
		TipoHistoriaPaciente tipoHistoria,
		IdAseguradoraPaciente aseguradoraId,
		IdEmpresaPaciente empresaId,
		EmailPaciente email,
		FotoPaciente fotoPaciente,
		TituloPaciente titulo,
		ObservacionPaciente observacion,
		InformacionClinicaPaciente informacionClinicaId,
		IdEstudioPaciente estudioId,
		IdSedePaciente sedeId,
		CelularPaciente celular)
	{
		this.pacienteId = pacienteId;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.estado = estado;
		this.ocupacion = ocupacion;
		this.direccion = direccion;
		this.paisId = paisId;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.ubigeo = ubigeo;
		this.tipoPacienteId = tipoPacienteId;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.nombreContacto = nombreContacto;
		this.tipoHistoria = tipoHistoria;
		this.aseguradoraId = aseguradoraId;
		this.empresaId = empresaId;
		this.email = email;
		this.fotoPaciente = fotoPaciente;
		this.titulo = titulo;
		this.observacion = observacion;
		this.informacionClinicaId = informacionClinicaId;
		this.estudioId = estudioId;
		this.sedeId = sedeId;
		this.celular = celular;
	}

	// 🔹 Métodos de actualización (siguiendo el estilo de Cita)
	public void actualizarTipoDocumento(TipoDocumentoPaciente tipoDocumento)
	{
		if (tipoDocumento != null)
			this.tipoDocumento = tipoDocumento;
	}

	public void actualizarNumeroDocumento(NumeroDocPaciente numeroDocumento)
	{
		if (numeroDocumento != null)
			this.numeroDocumento = numeroDocumento;
	}

	public void actualizarApellidos(ApellidoPaciente apellidos)
	{
		if (apellidos != null)
			this.apellidos = apellidos;
	}

	public void actualizarNombres(NombrePaciente nombres)
	{
		if (nombres != null)
			this.nombres = nombres;
	}

	public void actualizarFechaNacimiento(FNacimientoPaciente fechaNacimiento)
	{
		if (fechaNacimiento != null)
			this.fechaNacimiento = fechaNacimiento;
	}

	public void actualizarEdad(EdadPaciente edad)
	{
		if (edad != null)
			this.edad = edad;
	}

	public void actualizarEstado(EstadoPaciente estado)
	{
		if (estado != null)
			this.estado = estado;
	}

	public void actualizarOcupacion(OcupacionPaciente ocupacion)
	{
		if (ocupacion != null)
			this.ocupacion = ocupacion;
	}

	public void actualizarDireccion(DireccionPaciente direccion)
	{
		if (direccion != null)
			this.direccion = direccion;
	}

	public void actualizarPais(IdPaisPaciente paisId)
	{
		if (paisId != null)
			this.paisId = paisId;
	}

	public void actualizarDepartamento(DepartamentoPaciente departamento)
	{
		if (departamento != null)
			this.departamento = departamento;
	}

	public void actualizarProvincia(ProvinciaPaciente provincia)
	{
		if (provincia != null)
			this.provincia = provincia;
	}

	public void actualizarDistrito(DistritoPaciente distrito)
	{
		if (distrito != null)
			this.distrito = distrito;
	}

	public void actualizarUbigeo(UbigeoPaciente ubigeo)
	{
		if (ubigeo != null)
			this.ubigeo = ubigeo;
	}

	public void actualizarTipoPaciente(IdTipoPaciente tipoPacienteId)
	{
		if (tipoPacienteId != null)
			this.tipoPacienteId = tipoPacienteId;
	}

	public void actualizarEstadoCivil(EstadoCivilPaciente estadoCivil)
	{
		if (estadoCivil != null)
			this.estadoCivil = estadoCivil;
	}

	public void actualizarSexo(SexoPaciente sexo)
	{
		if (sexo != null)
			this.sexo = sexo;
	}

	public void actualizarNombreContacto(NombreContactoPaciente nombreContacto)
	{
		if (nombreContacto != null)
			this.nombreContacto = nombreContacto;
	}

	public void actualizarTipoHistoria(TipoHistoriaPaciente tipoHistoria)
	{
		if (tipoHistoria != null)
			this.tipoHistoria = tipoHistoria;
	}

	public void actualizarAseguradora(IdAseguradoraPaciente aseguradoraId)
	{
		if (aseguradoraId != null)
			this.aseguradoraId = aseguradoraId;
	}

	public void actualizarEmpresa(IdEmpresaPaciente empresaId)
	{
		if (empresaId != null)
			this.empresaId = empresaId;
	}

	public void actualizarEmail(EmailPaciente email)
	{
		if (email != null)
			this.email = email;
	}

	public void actualizarFoto(FotoPaciente fotoPaciente)
	{
		if (fotoPaciente != null)
			this.fotoPaciente = fotoPaciente;
	}

	public void actualizarTitulo(TituloPaciente titulo)
	{
		if (titulo != null)
			this.titulo = titulo;
	}

	public void actualizarObservacion(ObservacionPaciente observacion)
	{
		if (observacion != null)
			this.observacion = observacion;
	}

	public void actualizarInformacionClinica(InformacionClinicaPaciente informacionClinicaId)
	{
		if (informacionClinicaId != null)
			this.informacionClinicaId = informacionClinicaId;
	}

	public void actualizarEstudio(IdEstudioPaciente estudioId)
	{
		if (estudioId != null)
			this.estudioId = estudioId;
	}

	public void actualizarSede(IdSedePaciente sedeId)
	{
		if (sedeId != null)
			this.sedeId = sedeId;
	}

	public void actualizarCelular(CelularPaciente celular)
	{
		if (celular != null)
			this.celular = celular;
	}
}