package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.MedidaDTO;
import com.saludSystem.application.services.Catalogo.MedidaService;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedidaRepository;
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
public class MedidaServiceImpl implements MedidaService {

    private final MedidaRepository medidaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MedidaServiceImpl(MedidaRepository medidaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.medidaRepository = medidaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveMedida(CrearMedidaDTO crearMedidaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MedidaEntity medida = new MedidaEntity();
        medida.setNombre(crearMedidaDTO.getNombre());
        medida.setEstado(crearMedidaDTO.getEstado());
        medida.setUser(user);
        medida.setHospital(hospital);
        medidaRepository.save(medida);
        return new ApiResponse(true, "Medida registrada correctamente");
    }

    @Override
    public List<MedidaDTO> getMedidaList() {
        return medidaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MedidaDTO getMedidaById(UUID medidaId) {
        MedidaEntity medida = medidaRepository.findById(medidaId).orElseThrow( () -> new ResourceNotFoundException("Medida no encontrada"));
        return convertToDTO(medida);
    }

    @Override
    public ApiResponse updateMedida(UUID medidaId, ActualizarMedidaDTO actualizarMedidaDTO) {
        MedidaEntity medida = medidaRepository.findById(medidaId).orElseThrow(
                () -> new ResourceNotFoundException("Medida no encontrada con ID" + medidaId));
        Optional.ofNullable(actualizarMedidaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(medida::setNombre);
        Optional.ofNullable(actualizarMedidaDTO.getEstado()).ifPresent(medida::setEstado);
        medidaRepository.save(medida);
        return new ApiResponse(true, "Medida actualizada con exito");
    }

    @Override
    public ApiResponse deleteMedida(UUID medidaId) {
        medidaRepository.deleteById(medidaId);
        return new ApiResponse(true, "Medida eliminada correctamente");
    }

    @Override
    public ListResponse<MedidaDTO> getAllMedida(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MedidaEntity> medidasPage = medidaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MedidaDTO> data = medidasPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, medidasPage.getTotalElements(), medidasPage.getTotalPages(), medidasPage.getNumber() + 1);
    }

    private MedidaDTO convertToDTO(MedidaEntity medida) {
        return modelMapper.map(medida, MedidaDTO.class);
    }

}