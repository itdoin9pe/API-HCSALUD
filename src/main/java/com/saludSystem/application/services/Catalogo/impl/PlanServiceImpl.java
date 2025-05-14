package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarPlanDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearPlanDTO;
import com.saludSystem.application.dtos.Catalogo.GET.PlanDTO;
import com.saludSystem.application.services.Catalogo.PlanService;
import com.saludSystem.domain.model.Catalogo.PlanEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.PlanRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
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
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PlanEntity plan = new PlanEntity();
        plan.setNombrePlan(crearPlanDTO.getNombrePlan());
        plan.setFechaInicio(crearPlanDTO.getFechaInicio());
        plan.setFechaFinContrato(crearPlanDTO.getFechaFinContrato());
        plan.setMaxPlan(crearPlanDTO.getMaxPlan());
        plan.setUsuMax(crearPlanDTO.getUseMax());
        plan.setCostoPlan(crearPlanDTO.getCostoPlan());
        plan.setEstado(crearPlanDTO.getEstado());
        plan.setUser(user);
        plan.setHospital(hospital);
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
        PlanEntity plan = planRepository.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Plan no encontrado con ID"));
        Optional.ofNullable(actualizarPlanDTO.getNombrePlan()).filter(desc -> !desc.isBlank())
                .ifPresent(plan::setNombrePlan);
        Optional.ofNullable(actualizarPlanDTO.getFechaInicio()).ifPresent(plan::setFechaInicio);
        Optional.ofNullable(actualizarPlanDTO.getFechaFinContrato()).ifPresent(plan::setFechaFinContrato);
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
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PlanEntity> planPage = planRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PlanDTO> data = planPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, planPage.getTotalElements(), planPage.getTotalPages(), planPage.getNumber() + 1);
    }

    @Override
    public PlanDTO getPlanById(UUID planId) {
        PlanEntity plan = planRepository.findById(planId)
                .orElseThrow( () -> new RuntimeException("Plan no encontrado con Id"));
        return convertToDTO(plan);
    }

    private PlanDTO convertToDTO(PlanEntity plan) {
        return modelMapper.map(plan, PlanDTO.class);
    }

}