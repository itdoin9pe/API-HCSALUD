package com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.ActualizarInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.CrearInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.InformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.services.InformacionClinicaService;
import com.saludSystem.Generals.adapter.InformacionClinica.domain.InformacionClinicaModel;
import com.saludSystem.Generals.adapter.InformacionClinica.infraestructura.repositories.InformacionClinicaRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InformacionClinicaServiceImpl implements InformacionClinicaService {

    private final InformacionClinicaRepository informacionClinicaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public InformacionClinicaServiceImpl(InformacionClinicaRepository informacionClinicaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InformacionClinicaDTO> getInformacionClinicaList() {
        return informacionClinicaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        InformacionClinicaModel informacionClinica = new InformacionClinicaModel();
        informacionClinica.setNombre(crearInformacionClinicaDTO.getNombre());
        informacionClinica.setEstado(crearInformacionClinicaDTO.getEstado());
        informacionClinica.setUser(user);
        informacionClinica.setHospital(hospital);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion Clinica registrada correctamente");
    }

    @Override
    public InformacionClinicaDTO getInformacionClinicaById(UUID informacionClinicaId) {
        InformacionClinicaModel informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow( () -> new RuntimeException("Informacion clinica no encontrada"));
        return convertToDTO(informacionClinica);
    }

    @Override
    public ApiResponse deleteInformacionClinica(UUID informacionClinicaId) {
        informacionClinicaRepository.deleteById(informacionClinicaId);
        return new ApiResponse(true, "Informacion clinica eliminado correctamente");
    }

    @Override
    public ApiResponse updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO) {
        InformacionClinicaModel informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow(() -> new ResourceNotFoundException("InformacionClinica no encontrada con ID"));
        Optional.ofNullable(actualizarInformacionClinicaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(informacionClinica::setNombre);
        Optional.ofNullable(actualizarInformacionClinicaDTO.getEstado()).ifPresent(informacionClinica::setEstado);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion clinica actualizado correctamente");
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinicaModel informacionClinica) {
        return modelMapper.map(informacionClinica, InformacionClinicaDTO.class);
    }

}