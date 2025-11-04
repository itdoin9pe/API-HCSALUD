package com.saludsystem.submodules.core.catalogo.adapter.seeder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ApoderadoJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import jakarta.transaction.Transactional;

//@Service
public class ApoderadoSeederService
{
	/*
	private final ApoderadoJpaRepository apoderadoJpaRepository;

	public ApoderadoSeederService(ApoderadoJpaRepository apoderadoJpaRepository)
	{
		this.apoderadoJpaRepository = apoderadoJpaRepository;
	}

	@Transactional
	public void insertarMasivo()
	{
		if (apoderadoJpaRepository.count() > 0)
		{
			System.out.println("⚠️ Apoderados ya existen, no se insertan más.");
			return;
		}
		UUID hospitalId = UUID.fromString("d7ca061a-ba19-4d63-90cf-28ac5046a590");
		UUID userId = UUID.fromString("d0917a53-51a4-42ea-b947-324724bffdc1");
		List<ApoderadoEntity> lista = new ArrayList<>();
		for (int i = 1; i <= 200; i++)
		{
			ApoderadoEntity a = new ApoderadoEntity();
			a.setNombre("Apoderado " + i);
			a.setDireccion("Calle Falsa " + i);
			a.setTelefono("900000" + i);
			a.setTipoDocumento("DNI");
			a.setNroDocumento("0000" + i);
			a.setEstado(1);

			SysSaludEntity hospitalEntity = new SysSaludEntity();
			hospitalEntity.setHospitalId(hospitalId);
			a.setHospital(hospitalEntity);

			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(userId);
			a.setUser(userEntity);

			lista.add(a);
		}
		apoderadoJpaRepository.saveAll(lista);
	}

	 */
}