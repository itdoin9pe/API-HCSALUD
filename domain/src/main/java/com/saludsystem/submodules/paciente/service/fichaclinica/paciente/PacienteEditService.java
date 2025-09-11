package com.saludsystem.submodules.paciente.service.fichaclinica.paciente;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;

public class PacienteEditService
{
	private final PacienteDao pacienteDao;
	private final PacienteRepository pacienteRepository;

	public PacienteEditService(PacienteDao pacienteDao, PacienteRepository pacienteRepository)
	{
		this.pacienteDao = pacienteDao;
		this.pacienteRepository = pacienteRepository;
	}

	public Paciente execute(UUID uuid, Paciente paciente)
	{
		var currentPac = pacienteDao.getById(uuid);
		if (currentPac == null)
		{
			throw new IllegalArgumentException(PacienteConstant.INVALID_ID);
		}
		if (currentPac.getEstado() != null)
		{
			throw new IllegalStateException("El paciente se encuentra inactivo");
		}
		currentPac.actualizarTipoDocumento(paciente.getTipoDocumento());
		currentPac.actualizarNumeroDocumento(paciente.getNumeroDocumento());
		currentPac.actualizarApellidos(paciente.getApellidos());
		currentPac.actualizarNombres(paciente.getNombres());
		currentPac.actualizarFechaNacimiento(paciente.getFechaNacimiento());
		currentPac.actualizarEdad(paciente.getEdad());
		currentPac.actualizarEstado(paciente.getEstado());
		currentPac.actualizarOcupacion(paciente.getOcupacion());
		currentPac.actualizarDireccion(paciente.getDireccion());
		currentPac.actualizarPais(paciente.getPaisId());
		currentPac.actualizarDepartamento(paciente.getDepartamento());
		currentPac.actualizarProvincia(paciente.getProvincia());
		currentPac.actualizarDistrito(paciente.getDistrito());
		currentPac.actualizarUbigeo(paciente.getUbigeo());
		currentPac.actualizarTipoPaciente(paciente.getTipoPacienteId());
		currentPac.actualizarEstadoCivil(paciente.getEstadoCivil());
		currentPac.actualizarSexo(paciente.getSexo());
		currentPac.actualizarNombreContacto(paciente.getNombreContacto());
		currentPac.actualizarTipoHistoria(paciente.getTipoHistoria());
		currentPac.actualizarAseguradora(paciente.getAseguradoraId());
		currentPac.actualizarEmpresa(paciente.getEmpresaId());
		currentPac.actualizarEmail(paciente.getEmail());
		currentPac.actualizarFoto(paciente.getFotoPaciente());
		currentPac.actualizarTitulo(paciente.getTitulo());
		currentPac.actualizarObservacion(paciente.getObservacion());
		currentPac.actualizarInformacionClinica(paciente.getInformacionClinicaId());
		currentPac.actualizarEstudio(paciente.getEstudioId());
		currentPac.actualizarSede(paciente.getSedeId());
		currentPac.actualizarCelular(paciente.getCelular());
		return pacienteRepository.update(uuid, currentPac);
	}

}