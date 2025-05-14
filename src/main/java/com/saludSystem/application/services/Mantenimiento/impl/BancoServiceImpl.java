package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.BancoService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarBancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.BancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearBancoDTO;
import com.saludSystem.domain.model.Mantenimiento.BancoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.BancoRepository;
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
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public BancoServiceImpl(BancoRepository bancoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.bancoRepository = bancoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveBanco(CrearBancoDTO crearBancoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        BancoEntity bancoEntity = new BancoEntity();
        bancoEntity.setDescripcion(crearBancoDTO.getDescripcion());
        bancoEntity.setEstado(crearBancoDTO.getEstado());
        bancoEntity.setHospital(hospital);
        bancoEntity.setUser(user);
        bancoRepository.save(bancoEntity);
        return new ApiResponse(true, "Banco creado correctamente");
    }

    @Override
    public List<BancoDTO> getBancoList() {
        return bancoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BancoDTO getBancoById(UUID bancoId) {
        BancoEntity bancoEntity = bancoRepository.findById(bancoId)
                .orElseThrow( () -> new ResourceNotFoundException("Registro de Banco no encontrado"));
        return convertToDTO(bancoEntity);
    }

    @Override
    public ListResponse<BancoDTO> getAllBanco(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<BancoEntity> bancoModelPage = bancoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<BancoDTO> data = bancoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, bancoModelPage.getTotalElements(), bancoModelPage.getTotalPages(), bancoModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse updateBanco(UUID bancoId, ActualizarBancoDTO actualizarBancoDTO) {
        BancoEntity bancoEntity = bancoRepository.findById(bancoId).orElseThrow(
                () -> new ResourceNotFoundException("Registro de banco no encontrado"));
        Optional.ofNullable(actualizarBancoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(bancoEntity::setDescripcion);
        Optional.ofNullable(actualizarBancoDTO.getEstado()).ifPresent(bancoEntity::setEstado);
        bancoRepository.save(bancoEntity);
        return new ApiResponse(true, "Banco registrado correctamente");
    }

    @Override
    public ApiResponse deleteBanco(UUID bancoId) {
        bancoRepository.deleteById(bancoId);
        return new ApiResponse(true, "Banco eliminado correctamente");
    }

    private BancoDTO convertToDTO(BancoEntity bancoEntity) {
        return modelMapper.map(bancoEntity, BancoDTO.class);
    }

}