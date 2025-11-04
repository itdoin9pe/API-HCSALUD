package com.saludsystem.submodules.core.medico.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.medico.adapter.jpa.DoctorJpaRepository;
import com.saludsystem.submodules.core.medico.adapter.mapper.DoctorDboMapper;
import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.model.constant.DoctorConstant;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class DoctorMysqlRepository implements DoctorRepository
{
	private final DoctorJpaRepository doctorJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public DoctorMysqlRepository(DoctorJpaRepository doctorJpaRepository, AuthenticateUserPort authenticateUserPort)
	{
		this.doctorJpaRepository = doctorJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Doctor save(Doctor doctor)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		DoctorEntity entity = DoctorDboMapper.toEntity(doctor, userId, hospitalId);
		return DoctorDboMapper.toDomain(doctorJpaRepository.save(entity));
	}

	@Override
	public Doctor update(UUID uuid, Doctor doctor)
	{
		if (!doctorJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(DoctorConstant.ID_NOT_FOUND);
		}
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		DoctorEntity entity = DoctorDboMapper.toEntity(doctor, userId, hospitalId);
		return DoctorDboMapper.toDomain(doctorJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!doctorJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(DoctorConstant.ID_NOT_FOUND);
		}
		doctorJpaRepository.deleteById(uuid);
	}
}
