package com.saludSystem.Catalogo.Especialidad.aplicacion.services;

import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.ActualizarEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.CrearEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.EspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.dominio.EspecialidadModel;
import com.saludSystem.Catalogo.Especialidad.infraestructura.repositories.EspecialidadRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
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
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        EspecialidadModel especialidad = new EspecialidadModel();
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
        EspecialidadModel especialidad = especialidadRepository.findById(especialidadId).orElseThrow(
                () -> new ResourceNotFoundException("Especialidad no encontrada con ID" + especialidadId));
        Optional.ofNullable(actualizarEspecialidadDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setNombre);
        Optional.ofNullable(actualizarEspecialidadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setDescripcion);
        Optional.ofNullable(actualizarEspecialidadDTO.getEstado()).ifPresent(especialidad::setEstado);
        especialidadRepository.save(especialidad);
        return new ApiResponse(true, "Especialidad actualizado correctamente");
    }

    @Override
    public EspecialidadDTO getEspecialidadById(UUID especialidadId) {
        EspecialidadModel especialidad = especialidadRepository.findById(especialidadId)
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad no encontrada"));
        return convertToDTO(especialidad);
    }

    @Override
    public List<EspecialidadDTO> getEspecialidadList() {
        return especialidadRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteEspecialidad(UUID especialidadId) {
        especialidadRepository.deleteById(especialidadId);
        return new ApiResponse(true, "Especialidad eliminado correctamente");
    }

    @Override
    public ListResponse<EspecialidadDTO> getAllEspecialidad(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EspecialidadModel> especialidadPage = especialidadRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EspecialidadDTO> data = especialidadPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, especialidadPage.getTotalElements(), especialidadPage.getTotalPages(), especialidadPage.getNumber() + 1);
    }

    private EspecialidadDTO convertToDTO(EspecialidadModel especialidad){
        return modelMapper.map(especialidad, EspecialidadDTO.class);
    }

}