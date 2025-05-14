package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.Principal.PaisService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.application.dtos.Principal.POST.CrearPaisDTO;
import com.saludSystem.application.dtos.Principal.GET.PaisDTO;
import com.saludSystem.domain.model.Principal.PaisEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.PaisRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public PaisServiceImpl(PaisRepository paisRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.paisRepository = paisRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePais(CrearPaisDTO crearPaisDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PaisEntity pais = new PaisEntity();
        pais.setIso(crearPaisDTO.getIso());
        pais.setNombre(crearPaisDTO.getNombre());
        pais.setGentilicio(crearPaisDTO.getGentilicio());
        pais.setOrden(crearPaisDTO.getOrden());
        pais.setUser(user);
        pais.setHospital(hospital);
        paisRepository.save(pais);
        return new ApiResponse(true, "Pais registrado correctamente");
    }

    @Override
    public ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PaisEntity> paisModelPage = paisRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PaisDTO> data = paisModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, paisModelPage.getTotalElements(), paisModelPage.getTotalPages(), paisModelPage.getNumber() + 1);
    }

    @Override
    public List<PaisDTO> getPaisList() {
        return paisRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PaisDTO convertToDTO(PaisEntity pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

}