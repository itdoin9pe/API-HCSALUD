package com.saludSystem.services.modules.Catalogo.Plan.impl;

import com.saludSystem.dtos.catalago.Plan.ActualizarPlanDTO;
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
    public ActualizarPlanDTO updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Plan no encontrado con ID" + planId));

        Optional.ofNullable(actualizarPlanDTO.getNombrePlan()).filter(desc -> !desc.isBlank())
                .ifPresent(actualizarPlanDTO::setNombrePlan);
        Optional.ofNullable(actualizarPlanDTO.getFechaInicio()).ifPresent(actualizarPlanDTO::setFechaInicio);
        Optional.ofNullable(actualizarPlanDTO.getFechaFin()).ifPresent(actualizarPlanDTO::setFechaFin);
        Optional.of(actualizarPlanDTO.getMaxPlan()).ifPresent(actualizarPlanDTO::setMaxPlan);
        Optional.of(actualizarPlanDTO.getUseMax()).ifPresent(actualizarPlanDTO::setUseMax);
        Optional.ofNullable(actualizarPlanDTO.getEstado()).ifPresent(plan::setEstado);
        planRepository.save(plan);
        return modelMapper.map(plan, ActualizarPlanDTO.class);
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
