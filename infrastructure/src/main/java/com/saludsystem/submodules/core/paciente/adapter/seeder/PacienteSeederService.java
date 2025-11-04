package com.saludsystem.submodules.core.paciente.adapter.seeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.PacienteJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.entity.AseguradoraEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EmpresaEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EstudioEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.InformacionClinicaEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.PaisEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.TipoPacienteEntity;

import jakarta.transaction.Transactional;

//@Service
public class PacienteSeederService
{
	/*
	private final PacienteJpaRepository pacienteJpaRepository;

	public PacienteSeederService(PacienteJpaRepository pacienteJpaRepository)
	{
		this.pacienteJpaRepository = pacienteJpaRepository;
	}

	@Transactional
	public void insertarMasivo()
	{
		if (pacienteJpaRepository.count() > 0)
		{
			System.out.println("⚠️ Pacientes ya existen, no se insertan más.");
			return;
		}
		UUID hospitalId = UUID.fromString("d7ca061a-ba19-4d63-90cf-28ac5046a590");
		UUID userId = UUID.fromString("d0917a53-51a4-42ea-b947-324724bffdc1");
		// IDs de entidades que ya deben existir en tu BD
		Integer paisId = 2;
		Long tipoPacienteId = 1L;
		UUID aseguradoraId = UUID.fromString("2dbb77d0-b7c1-4da4-b933-e87e91de69e3");
		UUID empresaId = UUID.fromString("21326a8d-105a-4a47-ae44-8c7ff4426ee4");
		UUID infoClinicaId = UUID.fromString("a2eb67b2-19e9-4968-a1e6-abafe4e349cf");
		UUID estudioId = UUID.fromString("40b96631-6f38-4438-b243-5e09281df26f");
		UUID sedeId = UUID.fromString("980bcf54-31b6-4602-b9f3-ffc77c3ddc41");

		List<PacienteEntity> lista = new ArrayList<>();

		for (int i = 1; i <= 50; i++)
		{
			PacienteEntity p = new PacienteEntity();
			p.setPacienteId(UUID.randomUUID());
			p.setTipoDocumentoId("DNI");
			p.setNumeroDocumento("DOC" + String.format("%04d", i));
			p.setApellidos("Apellido " + i);
			p.setNombres("Nombre " + i);
			p.setFechaNacimiento(LocalDate.of(1990, 1, (i % 28) + 1));
			p.setEdad(30);
			p.setEstado(1);
			p.setOcupacion("Empleado");
			p.setDireccion("Calle Paciente " + i);
			p.setDepartamento("Lima");
			p.setProvincia("Lima");
			p.setDistrito("Miraflores");
			p.setUbigeo("150122");
			p.setEstadoCivil("SOLTERO");
			p.setSexo("M");
			p.setNombreContacto("Contacto " + i);
			p.setTipoHistoria("GENERAL");
			p.setEmail("paciente" + i + "@correo.com");
			p.setFotoPaciente(null);
			p.setTitulo("Sr.");
			p.setObservacion("Paciente de prueba " + i);
			p.setCelular("90000" + String.format("%03d", i));

			// 🔗 Relaciones
			PaisEntity pais = new PaisEntity();
			pais.setId(paisId);
			p.setPaisId(pais);

			TipoPacienteEntity tipoPaciente = new TipoPacienteEntity();
			tipoPaciente.setTipoPacienteId(tipoPacienteId);
			p.setTipoPacienteId(tipoPaciente);

			AseguradoraEntity aseguradora = new AseguradoraEntity();
			aseguradora.setAseguradoraId(aseguradoraId);
			p.setAseguradoraId(aseguradora);

			EmpresaEntity empresa = new EmpresaEntity();
			empresa.setEmpresaId(empresaId);
			p.setEmpresaId(empresa);

			InformacionClinicaEntity infoClinica = new InformacionClinicaEntity();
			infoClinica.setInformacionClinicaId(infoClinicaId);
			p.setInformacionClinicaId(infoClinica);

			EstudioEntity estudio = new EstudioEntity();
			estudio.setEstudioId(estudioId);
			p.setEstudioId(estudio);

			SedeEntity sede = new SedeEntity();
			sede.setSedeId(sedeId);
			p.setSedeId(sede);

			SysSaludEntity hospitalEntity = new SysSaludEntity();
			hospitalEntity.setHospitalId(hospitalId);
			p.setHospital(hospitalEntity);

			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(userId);
			p.setUser(userEntity);

			lista.add(p);
		}
		pacienteJpaRepository.saveAll(lista);
		System.out.println("✅ 50 Pacientes insertados correctamente.");

	}

	 */
}
