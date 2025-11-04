package com.saludsystem.submodules.core.cita.adapter.jpa.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.core.cita.adapter.jpa.CitaJpaRepository;
import com.saludsystem.submodules.core.cita.adapter.mapper.CitaDboMapper;
import com.saludsystem.submodules.response.ListResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The type Cita mysql dao.
 */
@Component
public class CitaMysqlDao implements CitaDao
{	
	@PersistenceContext
	private EntityManager entityManager;

	private final CitaJpaRepository citaJpaRepository;
	
	public CitaMysqlDao(CitaJpaRepository citaJpaRepository)
	{
		this.citaJpaRepository = citaJpaRepository;
	}

	@Override
	public Cita getById(UUID uuid)
	{
		return citaJpaRepository.findById(uuid).map(CitaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Cita> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = citaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Cita> data = pageResult.getContent().stream().map(CitaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Cita> getList()
	{
		return citaJpaRepository.findAll().stream().map(CitaDboMapper::toDomain).toList();
	}

	@Override
	public List<Cita> getByDoctorAndFecha(UUID doctorId, LocalDate fecha)
	{
		return entityManager
				.createQuery("SELECT c FROM CitaEntity c WHERE c.doctorId = :doctorId AND c.fecha = :fecha", Cita.class)
				.setParameter("doctorId", doctorId).setParameter("fecha", fecha).getResultList();
	}

}
