package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.get.PaisDTO;
import com.saludsystem.principal.application.dto.post.CrearPaisDTO;
import com.saludsystem.principal.application.service.PaisService;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.principal.domain.model.PaisEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.PaisRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final SysSaludRepository sysSaludRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public PaisServiceImpl(PaisRepository paisRepository, SysSaludRepository sysSaludRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.paisRepository = paisRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePais(CrearPaisDTO crearPaisDTO) {
        UserEntity user = authValidator.getCurrentUser();
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
        List<PaisDTO> data = paisModelPage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, paisModelPage.getTotalElements(), paisModelPage.getTotalPages(), paisModelPage.getNumber() + 1);
    }

    @Override
    public List<PaisDTO> getPaisList() {
        return paisRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    private PaisDTO convertToDTO(PaisEntity pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

}