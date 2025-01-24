package com.saludSystem.services.modules.Catalogo.Plan.impl;

import com.saludSystem.dtos.catalago.Plan.CrearPlanDTO;
import com.saludSystem.dtos.catalago.Plan.PlanDTO;
import com.saludSystem.entities.catalogo.Plan;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.services.modules.Catalogo.Plan.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public PlanServiceImpl(PlanRepository planRepository, ModelMapper modelMapper)
    {
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearPlanDTO savePlan(CrearPlanDTO crearPlanDTO) {
        Plan plan = modelMapper.map(crearPlanDTO, Plan.class);
        planRepository.save(plan);
        return modelMapper.map(plan, CrearPlanDTO.class);
    }

    @Override
    public List<PlanDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Plan> planPage = planRepository.findAll(pageable);
        return planPage.getContent().stream()
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .toList();
    }

    @Override
    public void deletePlan(UUID planId) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow( ()-> new RuntimeException("Plan no encontrado con ID" + planId));
        planRepository.delete(plan);
    }

    @Override
    public PlanDTO updatePlan(UUID planId, PlanDTO planDTO) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Plan no encontrado con ID" + planId));

        Optional.ofNullable(planDTO.getNombrePlan()).filter(desc -> !desc.isBlank())
                .ifPresent(planDTO::setNombrePlan);
        Optional.ofNullable(planDTO.getFechaInicio()).ifPresent(planDTO::setFechaInicio);
        Optional.ofNullable(planDTO.getFechaFin()).ifPresent(planDTO::setFechaFin);
        Optional.of(planDTO.getMaxPlan()).ifPresent(planDTO::setMaxPlan);
        Optional.of(planDTO.getUseMax()).ifPresent(planDTO::setUseMax);
        Optional.ofNullable(planDTO.getEstado()).ifPresent(plan::setEstado);
        return null;
    }

    @Override
    public Optional<PlanDTO> getPlanById(UUID planId) {
        return Optional.ofNullable(planRepository.findById(planId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Plan no encontrado con ID" + planId)));
    }

    @Override
    public long getTotalCount() {
        return planRepository.count();
    }

    private PlanDTO convertToDTO(Plan plan) {
        return modelMapper.map(plan, PlanDTO.class);
    }
}
