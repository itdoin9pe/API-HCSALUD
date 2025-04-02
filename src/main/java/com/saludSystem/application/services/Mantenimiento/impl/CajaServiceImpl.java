package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.CajaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCajaDTO;
import com.saludSystem.domain.model.Mantenimiento.CajaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.CajaRepository;
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
public class CajaServiceImpl implements CajaService {

    private final CajaRepository cajaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CajaServiceImpl(CajaRepository cajaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cajaRepository = cajaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCaja(CrearCajaDTO crearCajaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CajaEntity cajaEntity = new CajaEntity();
        cajaEntity.setNombre(crearCajaDTO.getNombre());
        cajaEntity.setEstado(crearCajaDTO.getEstado());
        cajaEntity.setHospital(hospital);
        cajaEntity.setUser(userEntity);
        cajaRepository.save(cajaEntity);
        return new ApiResponse(true, "Caja registrado correctamente");
    }

    @Override
    public List<CajaDTO> getCajaList() {
        return cajaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CajaDTO> getAllCaja(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CajaEntity> cajaModelPage = cajaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CajaDTO> data = cajaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, cajaModelPage.getTotalElements(), cajaModelPage.getTotalPages(), cajaModelPage.getNumber() +1 );
    }

    @Override
    public CajaDTO getCajaById(UUID cajaId) {
        CajaEntity cajaEntity = cajaRepository.findById(cajaId).orElseThrow( () -> new ResourceNotFoundException("Caja no encontrada"));
        return convertToDTO(cajaEntity);
    }

    @Override
    public ApiResponse updateCaja(UUID cajaId, ActualizarCajaDTO actualizarCajaDTO) {
        CajaEntity cajaEntity = cajaRepository.findById(cajaId).orElseThrow( () -> new ResourceNotFoundException("Caja no encontrada"));
        Optional.ofNullable(actualizarCajaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(cajaEntity::setNombre);
        Optional.ofNullable(actualizarCajaDTO.getEstado()).ifPresent(cajaEntity::setEstado);
        cajaRepository.save(cajaEntity);
        return new ApiResponse(true, "Caja actualizada correctamente");
    }

    @Override
    public ApiResponse deleteCaja(UUID cajaId) {
        cajaRepository.deleteById(cajaId);
        return new ApiResponse(true, "Caja eliminado correctamente");
    }

    CajaDTO convertToDTO(CajaEntity cajaEntity) {
        return modelMapper.map(cajaEntity, CajaDTO.class);
    }

}