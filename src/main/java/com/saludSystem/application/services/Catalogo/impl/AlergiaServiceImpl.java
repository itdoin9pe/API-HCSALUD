package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;
import com.saludSystem.application.services.Catalogo.AlergiaService;
import com.saludSystem.domain.model.Catalogo.AlergiaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.AlergiaRepository;
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
public class AlergiaServiceImpl implements AlergiaService {

    private final AlergiaRepository alergiaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AlergiaServiceImpl(AlergiaRepository alergiaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.alergiaRepository = alergiaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApiResponse saveAlergia(CrearAlergiaDTO crearAlergiaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        AlergiaEntity alergia = new AlergiaEntity();
        alergia.setNombre(crearAlergiaDTO.getNombre());
        alergia.setEstado(crearAlergiaDTO.getEstado());
        alergia.setUser(userEntity);
        alergia.setHospital(hospital);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia registrada correctamente");
    }

    @Override
    public List<AlergiaDTO> getAlergiaList() {
        return alergiaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteAlergia(UUID alergiaId) {
        alergiaRepository.deleteById(alergiaId);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public ApiResponse updateAlergia(UUID alergiaId, ActualizarAlergiaDTO actualizarAlergiaDTO) {
        AlergiaEntity alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));
        Optional.ofNullable(actualizarAlergiaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(alergia::setNombre);
        Optional.ofNullable(actualizarAlergiaDTO.getEstado()).ifPresent(alergia::setEstado);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public AlergiaDTO getAlergiaById(UUID alergiaId) {
        AlergiaEntity alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));;
        return convertToDTO(alergia);
    }

    @Override
    public ListResponse<AlergiaDTO> getAllAlergia(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AlergiaEntity> alergiaPage = alergiaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AlergiaDTO> data = alergiaPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, alergiaPage.getTotalElements(), alergiaPage.getTotalPages(), alergiaPage.getNumber() +1 );
    }

    private AlergiaDTO convertToDTO(AlergiaEntity alergia) {
        return modelMapper.map(alergia, AlergiaDTO.class);
    }

}