package com.saludsystem.submodules.core.paciente.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.EnfermedadEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.DiagnosticoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;

public class DiagnosticoDboMapper {

	public static DiagnosticoEntity toEntity(Diagnostico model, UUID userId, UUID hospitalId) {

		DiagnosticoEntity entity = new DiagnosticoEntity();
		entity.setPacienteDiagnosticoId(model.getId());

		PacienteEntity paciente = new PacienteEntity();
		paciente.setPacienteId(model.getPacienteId());
		entity.setPacienteEntity(paciente);
		
		EnfermedadEntity enfermedad = new EnfermedadEntity();
		enfermedad.setEnfermedadId(model.getEnfermedadId().toString());
		entity.setEnfermedadEntity(enfermedad);
		
		entity.setFecha(model.getFecha());
		entity.setDescripcion(model.getDescripcion());
		
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;

	}
	
	public static Diagnostico toDomain(DiagnosticoEntity entity) {
		
		return new Diagnostico(
				entity.getPacienteDiagnosticoId(), 
				entity.getPacienteEntity().getPacienteId(), 
				entity.getEnfermedadEntity().getEnfermedadId(), 
				entity.getFecha(), 
				entity.getDescripcion());
		
	}

}
