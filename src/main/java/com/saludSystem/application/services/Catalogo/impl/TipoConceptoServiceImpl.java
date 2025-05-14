package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import com.saludSystem.application.services.Catalogo.TipoConceptoService;
import com.saludSystem.domain.model.Catalogo.TipoConceptoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.TipoConceptoRepository;
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
public class TipoConceptoServiceImpl implements TipoConceptoService {

    private final TipoConceptoRepository tipoConceptoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoConceptoServiceImpl(TipoConceptoRepository tipoConceptoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoConceptoRepository = tipoConceptoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoConcepto(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoConceptoEntity tipoConceptoEntity = new TipoConceptoEntity();
        tipoConceptoEntity.setNombre(crearTipoConceptoDTO.getNombre());
        tipoConceptoEntity.setEstado(crearTipoConceptoDTO.getEstado());
        tipoConceptoEntity.setUser(user);
        tipoConceptoEntity.setHospital(hospital);
        tipoConceptoRepository.save(tipoConceptoEntity);
        return new ApiResponse(true, "Tipo concepto registrado correctamente");
    }

    @Override
    public ApiResponse updateTipoConcepto(UUID tipoConveptoId, ActualizarTipoConceptoDTO actualizarTipoConceptoDTO) {
        TipoConceptoEntity tipoConceptoEntity = tipoConceptoRepository.findById(tipoConveptoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo concepto no encontrado"));
        Optional.ofNullable(actualizarTipoConceptoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoConceptoEntity::setNombre);
        Optional.ofNullable(actualizarTipoConceptoDTO.getEstado()).ifPresent(tipoConceptoEntity::setEstado);
        tipoConceptoRepository.save(tipoConceptoEntity);
        return new ApiResponse(true, "Tipo concepto actualizado correctamente");
    }

    @Override
    public TipoConceptoDTO getTipoConceptoById(UUID tipoConceptoId) {
        TipoConceptoEntity tipoConceptoEntity = tipoConceptoRepository.findById(tipoConceptoId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo concepto no encontrado"));
        return convertToDTO(tipoConceptoEntity);
    }

    @Override
    public List<TipoConceptoDTO> getTipoConceptoList() {
        return tipoConceptoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteTipoConcepto(UUID tipoConceptoId) {
        tipoConceptoRepository.deleteById(tipoConceptoId);
        return new ApiResponse(true, "Tipo concepto eliminado correcamente");
    }

    @Override
    public ListResponse<TipoConceptoDTO> getAllTipoConcepto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoConceptoEntity> tipoConceptoModelPage = tipoConceptoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoConceptoDTO> data = tipoConceptoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoConceptoModelPage.getTotalElements(), tipoConceptoModelPage.getTotalPages(), tipoConceptoModelPage.getNumber() + 1);
    }

    private TipoConceptoDTO convertToDTO(TipoConceptoEntity tipoConceptoEntity) {
        return modelMapper.map(tipoConceptoEntity, TipoConceptoDTO.class);
    }

}