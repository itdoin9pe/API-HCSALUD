package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.CostoHospitalizacionEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.CostoHospitalizacionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.CostoHospitalizacionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.CostoHospitalizacionConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.CostoHospitalizacionRepository;

@Component
public class CostoHospitalizacionMysqlRepository implements CostoHospitalizacionRepository
{
	private final CostoHospitalizacionJpaRepository costoHospitalizacionJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public CostoHospitalizacionMysqlRepository(
		CostoHospitalizacionJpaRepository costoHospitalizacionJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.costoHospitalizacionJpaRepository = costoHospitalizacionJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public CostoHospitalizacion save(CostoHospitalizacion costoHospitalizacion)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		CostoHospitalizacionEntity entity = CostoHospitalizacionDboMapper.toEntity(costoHospitalizacion, hospitalId,
				userId);
		return CostoHospitalizacionDboMapper.toDomain(costoHospitalizacionJpaRepository.save(entity));
	}

	@Override
	public CostoHospitalizacion update(UUID uuid, CostoHospitalizacion costoHospitalizacion)
	{
		if (!costoHospitalizacionJpaRepository.existsById(uuid))
		{
			throw new IllegalArgumentException(CostoHospitalizacionConstant.ID_NOT_FOUND);
		}
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		CostoHospitalizacionEntity entity = CostoHospitalizacionDboMapper.toEntity(costoHospitalizacion, hospitalId,
				userId);
		return CostoHospitalizacionDboMapper.toDomain(costoHospitalizacionJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!costoHospitalizacionJpaRepository.existsById(uuid))
		{
			throw new IllegalArgumentException(CostoHospitalizacionConstant.ID_NOT_FOUND);
		}
		costoHospitalizacionJpaRepository.deleteById(uuid);
	}
}
