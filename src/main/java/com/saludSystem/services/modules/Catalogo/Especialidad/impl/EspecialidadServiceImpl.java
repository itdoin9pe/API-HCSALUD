package com.saludSystem.services.modules.Catalogo.Especialidad.impl;
/*
import com.saludSystem.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.User;
import com.saludSystem.entities.catalogo.Especialidad;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Catalogo.EspecialidadRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.services.modules.Catalogo.Especialidad.EspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.especialidadRepository = especialidadRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveEspecialidad(CrearEspecialidadDTO crearEspecialidadDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Especialidad especialidad = new Especialidad();
        especialidad.setDescripcion(crearEspecialidadDTO.getDescripcion());
        especialidad.setNombre(crearEspecialidadDTO.getNombre());
        especialidad.setEstado(crearEspecialidadDTO.getEstado());
        especialidad.setUser(user);
        especialidad.setHospital(hospital);
        especialidadRepository.save(especialidad);
        return new ApiResponse(true, "Especialidad creada correctamente");
    }

    @Override
    public ApiResponse updateEspecialidad(UUID especialidadId, ActualizarEspecialidadDTO actualizarEspecialidadDTO) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId).orElseThrow(
                () -> new ResourceNotFoundException("Especialidad no encontrada con ID" + especialidadId));
        Optional.ofNullable(actualizarEspecialidadDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setNombre);
        Optional.ofNullable(actualizarEspecialidadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setDescripcion);
        Optional.ofNullable(actualizarEspecialidadDTO.getEstado()).ifPresent(especialidad::setEstado);
        especialidadRepository.save(especialidad);
        return new ApiResponse(true, "Especialidad actualizado correctamente");
    }

    @Override
    public EspecialidadDTO getEspecialidadById(UUID especialidadId) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId)
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad no encontrada"));
        EspecialidadDTO dto = new EspecialidadDTO();
        dto.setEspecialidadId(especialidad.getEspecialidadId());
        dto.setDescripcion(especialidad.getDescripcion());
        dto.setNombre(especialidad.getNombre());
        dto.setEstado(especialidad.getEstado());
        return dto;
    }

    @Override
    public List<EspecialidadDTO> getEspecialidadList() {
        return especialidadRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteEspecialidad(UUID especialidadId) {
        especialidadRepository.deleteById(especialidadId);
        return new ApiResponse(true, "Especialidad eliminado correctamente");
    }

    @Override
    public ListResponse<EspecialidadDTO> getAllEspecialidad(UUID hospitalId, int page, int rows) {
        List<Especialidad> especialidads = especialidadRepository.findByHospital_HospitalId(hospitalId);
        List<EspecialidadDTO> data = especialidads.stream().map(especialidad -> {
            EspecialidadDTO dto = new EspecialidadDTO();
            dto.setEspecialidadId(especialidad.getEspecialidadId());
            dto.setDescripcion(especialidad.getDescripcion());
            dto.setNombre(especialidad.getNombre());
            dto.setEstado(especialidad.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    private EspecialidadDTO convertToDTO(Especialidad especialidad){
        return modelMapper.map(especialidad, EspecialidadDTO.class);
    }

}

 */