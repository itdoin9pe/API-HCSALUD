package com.saludsystem.submodules.paciente.model.entity;

import com.saludsystem.submodules.paciente.model.vo.paciente.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Paciente {
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

	public Paciente(IdPaciente pacienteId, TipoDocumentoPaciente tipoDocumento, NumeroDocPaciente numeroDocumento,
			ApellidoPaciente apellidos, NombrePaciente nombres, FNacimientoPaciente fechaNacimiento, EdadPaciente edad,
			EstadoPaciente estado, OcupacionPaciente ocupacion, DireccionPaciente direccion, IdPaisPaciente paisId,
			DepartamentoPaciente departamento, ProvinciaPaciente provincia, DistritoPaciente distrito,
			UbigeoPaciente ubigeo, IdTipoPaciente tipoPacienteId, EstadoCivilPaciente estadoCivil, SexoPaciente sexo,
			NombreContactoPaciente nombreContacto, TipoHistoriaPaciente tipoHistoria,
			IdAseguradoraPaciente aseguradoraId, IdEmpresaPaciente empresaId, EmailPaciente email,
			FotoPaciente fotoPaciente, TituloPaciente titulo, ObservacionPaciente observacion,
			InformacionClinicaPaciente informacionClinicaId, IdEstudioPaciente estudioId, IdSedePaciente sedeId,
			CelularPaciente celular) {
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
}