package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.TipoPagoService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;
import com.saludSystem.domain.model.Mantenimiento.TipoPagoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoPagoRepository;
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
public class TipoPagoServiceImpl implements TipoPagoService {

    private final TipoPagoRepository tipoPagoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoPagoServiceImpl(TipoPagoRepository tipoPagoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoPagoRepository = tipoPagoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoPago(CrearTipoPagoDTO crearTipoPagoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoPagoEntity tipoPagoEntity = new TipoPagoEntity();
        tipoPagoEntity.setMetodoPago(crearTipoPagoDTO.getMetodoPago());
        tipoPagoEntity.setDescripcion(crearTipoPagoDTO.getDescripcion());
        tipoPagoEntity.setEstado(crearTipoPagoDTO.getEstado());
        tipoPagoEntity.setUser(user);
        tipoPagoEntity.setHospital(hospital);
        tipoPagoRepository.save(tipoPagoEntity);
        return new ApiResponse(true, "Tipo pago registrado correctamente");
    }

    @Override
    public ListResponse<TipoPagoDTO> getAllTipoPago(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoPagoEntity> tipoPagoModelPage = tipoPagoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoPagoDTO> data = tipoPagoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoPagoModelPage.getTotalElements(), tipoPagoModelPage.getTotalPages(), tipoPagoModelPage.getNumber() + 1);
    }

    @Override
    public List<TipoPagoDTO> getListTipoPago() {
        return tipoPagoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TipoPagoDTO getTipoPagoById(UUID tipoPagoId) {
        TipoPagoEntity tipoPagoEntity = tipoPagoRepository.findById(tipoPagoId).orElseThrow( () -> new ResourceNotFoundException("Tipo Pago no encontrado"));
        return convertToDTO(tipoPagoEntity);
    }

    @Override
    public ApiResponse updateTipoPago(UUID tipoPagoId, ActualizarTipoPagoDTO actualizarTipoPagoDTO) {
        TipoPagoEntity tipoPagoEntity = tipoPagoRepository.findById(tipoPagoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo pago no encontrado"));
        Optional.ofNullable(actualizarTipoPagoDTO.getMetodoPago()).filter(desc -> !desc.isBlank()).ifPresent(tipoPagoEntity::setMetodoPago);
        Optional.ofNullable(actualizarTipoPagoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tipoPagoEntity::setDescripcion);
        Optional.ofNullable(actualizarTipoPagoDTO.getEstado()).ifPresent(tipoPagoEntity::setEstado);
        tipoPagoRepository.save(tipoPagoEntity);
        return new ApiResponse(true, "Tipo pago actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoPago(UUID tipoPagoId) {
        tipoPagoRepository.deleteById(tipoPagoId);
        return new ApiResponse(true, "Tipo pago eliminado correctamente");
    }

    private TipoPagoDTO convertToDTO(TipoPagoEntity tipoPagoEntity) {
        return modelMapper.map(tipoPagoEntity, TipoPagoDTO.class);
    }

}