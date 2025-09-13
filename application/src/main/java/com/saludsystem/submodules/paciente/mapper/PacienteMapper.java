package com.saludsystem.submodules.paciente.mapper;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.command.create.PacienteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PacienteEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
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

public class PacienteMapper
{
	public Paciente fromCreateDto(PacienteCreateCommand createCommand)
	{
		return new Paciente(new IdPaciente(UUID.randomUUID()),
				new TipoDocumentoPaciente(createCommand.getTipoDocumentoId()),
				new NumeroDocPaciente(createCommand.getNumeroDocumento()),
				new ApellidoPaciente(createCommand.getApellidos()), new NombrePaciente(createCommand.getNombres()),
				new FNacimientoPaciente(createCommand.getFechaNacimiento()), new EdadPaciente(createCommand.getEdad()),
				new EstadoPaciente(createCommand.getEstado()), new OcupacionPaciente(createCommand.getOcupacion()),
				new DireccionPaciente(createCommand.getDireccion()), new IdPaisPaciente(createCommand.getPaisId()),
				new DepartamentoPaciente(createCommand.getDepartamento()),
				new ProvinciaPaciente(createCommand.getProvincia()), new DistritoPaciente(createCommand.getDistrito()),
				new UbigeoPaciente(createCommand.getUbigeo()), new IdTipoPaciente(createCommand.getTipoPacienteId()),
				new EstadoCivilPaciente(createCommand.getEstadoCivil()), new SexoPaciente(createCommand.getSexo()),
				new NombreContactoPaciente(createCommand.getNombreContacto()),
				new TipoHistoriaPaciente(createCommand.getTipoHistoria()),
				new IdAseguradoraPaciente(createCommand.getAseguradoraId()),
				new IdEmpresaPaciente(createCommand.getEmpresaId()), new EmailPaciente(createCommand.getEmail()),
				new FotoPaciente(createCommand.getFotoPaciente()), new TituloPaciente(createCommand.getTitulo()),
				new ObservacionPaciente(createCommand.getObservacion()),
				new InformacionClinicaPaciente(createCommand.getInformacionClinicaId()),
				new IdEstudioPaciente(createCommand.getEstudioId()), new IdSedePaciente(createCommand.getSedeId()),
				new CelularPaciente(createCommand.getCelular()));
	}

	public Paciente fromUpdateDto(UUID uuid, PacienteEditCommand editCommand)
	{
		return new Paciente(new IdPaciente(editCommand.getPacienteId()),
				new TipoDocumentoPaciente(editCommand.getTipoDocumentoId()),
				new NumeroDocPaciente(editCommand.getNumeroDocumento()),
				new ApellidoPaciente(editCommand.getApellidos()), new NombrePaciente(editCommand.getNombres()),
				new FNacimientoPaciente(editCommand.getFechaNacimiento()), new EdadPaciente(editCommand.getEdad()),
				new EstadoPaciente(editCommand.getEstado()), new OcupacionPaciente(editCommand.getOcupacion()),
				new DireccionPaciente(editCommand.getDireccion()), new IdPaisPaciente(editCommand.getPaisId()),
				new DepartamentoPaciente(editCommand.getDepartamento()),
				new ProvinciaPaciente(editCommand.getProvincia()), new DistritoPaciente(editCommand.getDistrito()),
				new UbigeoPaciente(editCommand.getUbigeo()), new IdTipoPaciente(editCommand.getTipoPacienteId()),
				new EstadoCivilPaciente(editCommand.getEstadoCivil()), new SexoPaciente(editCommand.getSexo()),
				new NombreContactoPaciente(editCommand.getNombreContacto()),
				new TipoHistoriaPaciente(editCommand.getTipoHistoria()),
				new IdAseguradoraPaciente(editCommand.getAseguradoraId()),
				new IdEmpresaPaciente(editCommand.getEmpresaId()), new EmailPaciente(editCommand.getEmail()),
				new FotoPaciente(editCommand.getFotoPaciente()), new TituloPaciente(editCommand.getTitulo()),
				new ObservacionPaciente(editCommand.getObservacion()),
				new InformacionClinicaPaciente(editCommand.getInformacionClinicaId()),
				new IdEstudioPaciente(editCommand.getEstudioId()), new IdSedePaciente(editCommand.getSedeId()),
				new CelularPaciente(editCommand.getCelular()));
	}

	public PacienteDTO toDto(Paciente model)
	{
		return new PacienteDTO(model.getPacienteId().value(), model.getTipoDocumento().value(),
				model.getNumeroDocumento().value(), model.getApellidos().value(), model.getNombres().value(),
				model.getFechaNacimiento().value(), model.getEdad().value(), model.getEstado().value(),
				model.getOcupacion().value(), model.getDireccion().value(), model.getPaisId().value(),
				model.getDepartamento().value(), model.getProvincia().value(), model.getDistrito().value(),
				model.getUbigeo().value(), model.getTipoPacienteId().value(), model.getEstadoCivil().value(),
				model.getSexo().value(), model.getNombreContacto().value(), model.getTipoHistoria().value(),
				model.getAseguradoraId().value(), model.getEmpresaId().value(), model.getEmail().email(),
				model.getFotoPaciente().value(), model.getTitulo().value(), model.getObservacion().value(),
				model.getInformacionClinicaId().value(), model.getEstudioId().value(), model.getSedeId().value(),
				model.getCelular().value());
	}
}