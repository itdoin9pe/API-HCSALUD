package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.PlanJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.PlanDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class PlanMysqlDao implements PlanDao
{
	private final PlanJpaRepository planJpaRepository;

	public PlanMysqlDao(PlanJpaRepository planJpaRepository)
	{
		this.planJpaRepository = planJpaRepository;
	}

	@Override
	public Plan getById(UUID uuid)
	{
		return planJpaRepository.findById(uuid).map(PlanDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Plan> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = planJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Plan> data = pageResult.getContent().stream().map(PlanDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Plan> getList()
	{
		return planJpaRepository.findAll().stream().map(PlanDboMapper::toDomain).toList();
	}
}