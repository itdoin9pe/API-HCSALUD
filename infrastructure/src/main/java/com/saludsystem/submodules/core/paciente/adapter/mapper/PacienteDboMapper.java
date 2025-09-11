package com.saludsystem.submodules.core.paciente.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.AseguradoraEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EmpresaEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EstudioEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.InformacionClinicaEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.PaisEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.TipoPacienteEntity;
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

public class PacienteDboMapper
{
	public static PacienteEntity toEntity(Paciente model, UUID hospitalId, UUID userId)
	{
		PacienteEntity entity = new PacienteEntity();
		entity.setPacienteId(model.getPacienteId().value());
		entity.setTipoDocumentoId(model.getTipoDocumento().value());
		entity.setNumeroDocumento(model.getNumeroDocumento().value());
		entity.setApellidos(model.getApellidos().value());
		entity.setNombres(model.getNombres().value());
		entity.setFechaNacimiento(model.getFechaNacimiento().value());
		entity.setEdad(model.getEdad().value());
		entity.setEstado(model.getEstado().value());
		entity.setOcupacion(model.getOcupacion().value());
		entity.setDireccion(model.getDireccion().value());
		// Pais
		var paisEntity = new PaisEntity();
		paisEntity.setId(model.getPaisId().value());
		entity.setPaisId(paisEntity);
		// patient other objects
		entity.setDepartamento(model.getDepartamento().value());
		entity.setProvincia(model.getProvincia().value());
		entity.setDistrito(model.getDistrito().value());
		entity.setUbigeo(model.getUbigeo().value());
		// Tipo paciente
		var tipoPacienteEntity = new TipoPacienteEntity();
		tipoPacienteEntity.setTipoPacienteId(model.getTipoPacienteId().value());
		entity.setTipoPacienteId(tipoPacienteEntity);
		// other pacient objects
		entity.setEstadoCivil(model.getEstadoCivil().value());
		entity.setSexo(model.getSexo().value());
		entity.setNombreContacto(model.getNombreContacto().value());
		entity.setTipoHistoria(model.getTipoHistoria().value());
		// Aseguradora
		var aseguradoraEntity = new AseguradoraEntity();
		aseguradoraEntity.setAseguradoraId(model.getAseguradoraId().value());
		entity.setAseguradoraId(aseguradoraEntity);
		// Empresa
		var empresaEntity = new EmpresaEntity();
		empresaEntity.setEmpresaId(model.getEmpresaId().value());
		entity.setEmpresaId(empresaEntity);
		// other patient 
		entity.setEmail(model.getEmail().email());
		entity.setFotoPaciente(model.getFotoPaciente().value());
		entity.setTitulo(model.getTitulo().value());
		entity.setObservacion(model.getObservacion().value());
		// Info cli
		var infoClinicaEntity = new InformacionClinicaEntity();
		infoClinicaEntity.setInformacionClinicaId(model.getInformacionClinicaId().value());
		entity.setInformacionClinicaId(infoClinicaEntity);
		// Estudio 
		var estudioEntity = new EstudioEntity();
		estudioEntity.setEstudioId(model.getEstudioId().value());
		entity.setEstudioId(estudioEntity);
		// sede
		var sedeEntity = new SedeEntity();
		sedeEntity.setSedeId(model.getSedeId().value());
		entity.setSedeId(sedeEntity);
		// patient other object
		entity.setCelular(model.getCelular().value());
		// audit
		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);
		return entity;
	}

	public static Paciente toDomain(PacienteEntity entity)
	{
		return new Paciente(new IdPaciente(entity.getPacienteId()),
				new TipoDocumentoPaciente(entity.getTipoDocumentoId()),
				new NumeroDocPaciente(entity.getNumeroDocumento()), new ApellidoPaciente(entity.getApellidos()),
				new NombrePaciente(entity.getNombres()), new FNacimientoPaciente(entity.getFechaNacimiento()),
				new EdadPaciente(entity.getEdad()), new EstadoPaciente(entity.getEstado()),
				new OcupacionPaciente(entity.getOcupacion()), new DireccionPaciente(entity.getDireccion()),
				new IdPaisPaciente(entity.getPaisId().getId()), new DepartamentoPaciente(entity.getDepartamento()),
				new ProvinciaPaciente(entity.getProvincia()), new DistritoPaciente(entity.getDistrito()),
				new UbigeoPaciente(entity.getUbigeo()),
				new IdTipoPaciente(entity.getTipoPacienteId().getTipoPacienteId()),
				new EstadoCivilPaciente(entity.getEstadoCivil()), new SexoPaciente(entity.getSexo()),
				new NombreContactoPaciente(entity.getNombreContacto()),
				new TipoHistoriaPaciente(entity.getTipoHistoria()),
				new IdAseguradoraPaciente(entity.getAseguradoraId().getAseguradoraId()),
				new IdEmpresaPaciente(entity.getEmpresaId().getEmpresaId()), new EmailPaciente(entity.getEmail()),
				new FotoPaciente(entity.getFotoPaciente()), new TituloPaciente(entity.getTitulo()),
				new ObservacionPaciente(entity.getObservacion()),
				new InformacionClinicaPaciente(entity.getInformacionClinicaId().getInformacionClinicaId()),
				new IdEstudioPaciente(entity.getEstudioId().getEstudioId()),
				new IdSedePaciente(entity.getSedeId().getSedeId()), new CelularPaciente(entity.getCelular()));
	}

}