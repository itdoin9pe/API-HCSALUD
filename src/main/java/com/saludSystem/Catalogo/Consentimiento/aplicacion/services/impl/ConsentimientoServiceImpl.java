package com.saludSystem.Catalogo.Consentimiento.aplicacion.services.impl;

import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.ActualizarConsentimientoDTO;
import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.ConsentimientoDTO;
import com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos.CrearConsentimientoDTO;
import com.saludSystem.Catalogo.Consentimiento.infraestructura.repository.ConsentimientoRepository;
import com.saludSystem.Catalogo.Consentimiento.dominio.ConsentimientoModel;
import com.saludSystem.Catalogo.Consentimiento.aplicacion.services.ConsentimientoService;
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
public class ConsentimientoServiceImpl implements ConsentimientoService {

    private final ConsentimientoRepository consentimientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ConsentimientoServiceImpl(ConsentimientoRepository consentimientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.consentimientoRepository = consentimientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveConsentimiento(CrearConsentimientoDTO crearConsentimientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ConsentimientoModel consentimientoModel = new ConsentimientoModel();
        consentimientoModel.setNombre(crearConsentimientoDTO.getNombre());
        consentimientoModel.setObservacion(crearConsentimientoDTO.getObservacion());
        consentimientoModel.setEstado(crearConsentimientoDTO.getEstado());
        consentimientoModel.setTexto(crearConsentimientoDTO.getTexto());
        consentimientoModel.setUser(user);
        consentimientoModel.setHospital(hospital);
        consentimientoRepository.save(consentimientoModel);
        return new ApiResponse(true, "Consentimiento registrado correctamente");
    }

    @Override
    public ApiResponse updateConsentimiento(UUID consentimientoId, ActualizarConsentimientoDTO actualizarConsentimientoDTO) {
        ConsentimientoModel consentimientoModel = consentimientoRepository.findById(consentimientoId)
                .orElseThrow( () -> new ResourceNotFoundException("Consentimiento no encontrado"));
        Optional.ofNullable(actualizarConsentimientoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoModel::setNombre);
        Optional.ofNullable(actualizarConsentimientoDTO.getObservacion()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoModel::setObservacion);
        Optional.ofNullable(actualizarConsentimientoDTO.getEstado()).ifPresent(consentimientoModel::setEstado);
        Optional.ofNullable(actualizarConsentimientoDTO.getTexto()).filter(desc -> !desc.isBlank()).ifPresent(consentimientoModel::setTexto);
        consentimientoRepository.save(consentimientoModel);
        return new ApiResponse(true, "Consentimiento actualizado correctamente");
    }

    @Override
    public ConsentimientoDTO getConsentimientoById(UUID consentimientoId) {
        ConsentimientoModel consentimientoModel = consentimientoRepository.findById(consentimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Consentimiento no encontrado"));
        return convertToDTO(consentimientoModel);
    }

    @Override
    public ApiResponse deleteConsentimiento(UUID consentimientoId) {
        consentimientoRepository.deleteById(consentimientoId);
        return new ApiResponse(true, "Consentimiento eliminado correctamente");
    }

    @Override
    public ListResponse<ConsentimientoDTO> getAllConsentimiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ConsentimientoModel> consentimientoModelPage = consentimientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ConsentimientoDTO> data = consentimientoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, consentimientoModelPage.getTotalElements(), consentimientoModelPage.getTotalPages(), consentimientoModelPage.getNumber() + 1);
    }

    private ConsentimientoDTO convertToDTO(ConsentimientoModel consentimientoModel) {
        return modelMapper.map(consentimientoModel, ConsentimientoDTO.class);
    }

}