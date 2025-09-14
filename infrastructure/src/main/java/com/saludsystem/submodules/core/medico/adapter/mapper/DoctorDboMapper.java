package com.saludsystem.submodules.core.medico.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.vo.usuario.NumeroDocumento;
import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.medico.model.Doctor;
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

public class DoctorDboMapper
{
	public static DoctorEntity toEntity(Doctor model, UUID userId, UUID hospitalId)
	{
		DoctorEntity entity = new DoctorEntity();
		entity.setDoctorId(model.getId().value());
		entity.setTipoDocumento(model.getTipoDocumento().value());
		entity.setNumeroDocumento(model.getNumeroDocumento().value());
		entity.setApellidos(model.getApellidos().value());
		entity.setNombres(model.getNombres().value());
		entity.setDireccion(model.getDireccion().value());
		entity.setCorreo(model.getCorreo().value());
		entity.setAbreviatura(model.getAbreviatura());
		entity.setRne(model.getRne().value());
		entity.setFechaNacimiento(model.getFechaNacimiento());
		entity.setCelular(model.getCelular().value());
		entity.setTelefono(model.getTelefono().value());
		entity.setSexo(model.getSexo());
		EspecialidadEntity especialidad = new EspecialidadEntity();
		especialidad.setEspecialidadId(model.getEspecialidadId().value());
		entity.setEspecialidadId(especialidad);
		entity.setColegiatura(model.getColegiatura().value());
		entity.setColor(model.getColor());
		entity.setEstado(model.getEstado());
		entity.setFotoDoctor(model.getFotoDoctor());
		entity.setFotoFirma(model.getFotoFirma());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Doctor toDomain(DoctorEntity entity)
	{
		return new Doctor(new DoctorId(entity.getDoctorId()), new TipoDocumento(entity.getTipoDocumento()),
				new NumeroDocumento(entity.getNumeroDocumento()), new Apellido(entity.getApellidos()),
				new Nombre(entity.getNombres()), new Direccion(entity.getDireccion()), new Correo(entity.getCorreo()),
				entity.getAbreviatura(), new Rne(entity.getRne()), entity.getFechaNacimiento(),
				new Celular(entity.getCelular()), new Telefono(entity.getTelefono()), entity.getSexo(),
				new EspecialidadId(entity.getEspecialidadId().getEspecialidadId()),
				new Colegiatura(entity.getColegiatura()), entity.getColor(), entity.getEstado(), entity.getFotoFirma(),
				entity.getFotoDoctor());
	}
}
