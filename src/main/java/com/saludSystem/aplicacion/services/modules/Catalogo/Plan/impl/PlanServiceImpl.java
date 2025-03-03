package com.saludSystem.aplicacion.services.modules.Catalogo.Plan.impl;
/*
import com.saludSystem.dtos.catalago.Plan.ActualizarPlanDTO;
import com.saludSystem.dtos.catalago.Plan.CrearPlanDTO;
import com.saludSystem.dtos.catalago.Plan.PlanDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.User;
import com.saludSystem.entities.catalogo.Plan;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.services.modules.Catalogo.Plan.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public PlanServiceImpl(PlanRepository planRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePlan(CrearPlanDTO crearPlanDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Plan plan = new Plan();
        plan.setNombrePlan(crearPlanDTO.getNombrePlan());
        plan.setFechaInicio(crearPlanDTO.getFechaInicio());
        plan.setFechaFin(crearPlanDTO.getFechaFin());
        plan.setMaxPlan(crearPlanDTO.getMaxPlan());
        plan.setUsuMax(crearPlanDTO.getUseMax());
        plan.setCostoPlan(crearPlanDTO.getCostoPlan());
        plan.setEstado(crearPlanDTO.getEstado());
        //plan.setUser(user);
        //plan.setHospital(hospital);
        planRepository.save(plan);
        return new ApiResponse(true, "Plan registrado correctamente");
    }

    @Override
    public ApiResponse deletePlan(UUID planId) {
        planRepository.deleteById(planId);
        return new ApiResponse(true, "Plan eliminado correctamente");
    }

    @Override
    public ApiResponse updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Plan no encontrado con ID" + planId));

        Optional.ofNullable(actualizarPlanDTO.getNombrePlan()).filter(desc -> !desc.isBlank())
                .ifPresent(plan::setNombrePlan);
        Optional.ofNullable(actualizarPlanDTO.getFechaInicio()).ifPresent(plan::setFechaInicio);
        Optional.ofNullable(actualizarPlanDTO.getFechaFin()).ifPresent(plan::setFechaFin);
        if (actualizarPlanDTO.getMaxPlan() > 0) {
            plan.setMaxPlan(actualizarPlanDTO.getMaxPlan());
        }
        if (actualizarPlanDTO.getUseMax() > 0) {
            plan.setUsuMax(actualizarPlanDTO.getUseMax());
        }
        Optional.ofNullable(actualizarPlanDTO.getCostoPlan()).ifPresent(plan::setCostoPlan);
        Optional.ofNullable(actualizarPlanDTO.getEstado()).ifPresent(plan::setEstado);
        planRepository.save(plan);
        return new ApiResponse(true, "Plan actualizado correctamente");
    }

    @Override
    public ListResponse<PlanDTO> getAllPlan(UUID hospitalId, int page, int rows) {
        List<Plan> plans = planRepository.findByHospital_HospitalId(hospitalId);
        List<PlanDTO> data = plans.stream().map(plan -> {
            PlanDTO dto = new PlanDTO();
            dto.setPlanId(plan.getPlanId());
            dto.setNombrePlan(plan.getNombrePlan());
            dto.setFechaInicio(plan.getFechaInicio());
            dto.setFechaFin(plan.getFechaFin());
            dto.setMaxPlan(plan.getMaxPlan());
            dto.setUseMax(plan.getUsuMax());
            dto.setCostoPlan(plan.getCostoPlan());
            dto.setEstado(plan.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public PlanDTO getPlanById(UUID planId) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow( () -> new RuntimeException("Plan no encontrado con Id" + planId));
        PlanDTO dto = new PlanDTO();
        dto.setPlanId(plan.getPlanId());
        dto.setNombrePlan(plan.getNombrePlan());
        dto.setFechaInicio(plan.getFechaInicio());
        dto.setFechaFin(plan.getFechaFin());
        dto.setMaxPlan(plan.getMaxPlan());
        dto.setUseMax(plan.getUsuMax());
        dto.setCostoPlan(plan.getCostoPlan());
        dto.setEstado(plan.getEstado());
        return dto;
    }

}

 */