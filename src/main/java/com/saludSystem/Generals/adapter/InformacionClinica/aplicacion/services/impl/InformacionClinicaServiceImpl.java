package com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.services.impl;
/*
import com.saludSystem.dtos.Generals.InformacionClinica.ActualizarInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.CrearInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.InformacionClinicaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.InformacionClinicaRepository;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
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
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        InformacionClinica informacionClinica = new InformacionClinica();
        informacionClinica.setNombre(crearInformacionClinicaDTO.getNombre());
        informacionClinica.setEstado(crearInformacionClinicaDTO.getEstado());
        informacionClinica.setUser(user);
        informacionClinica.setHospital(hospital);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion Cliinca registrada correctamente");
    }

    @Override
    public InformacionClinicaDTO getInformacionClinicaById(UUID informacionClinicaId) {
        InformacionClinica informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow( () -> new RuntimeException("Informacion clinica no encontrada"));
        InformacionClinicaDTO dto = new InformacionClinicaDTO();
        dto.setInformacionClinicaId(informacionClinica.getInformacionClinicaId());
        dto.setNombre(informacionClinica.getNombre());
        dto.setEstado(informacionClinica.getEstado());
        return dto;
    }

    @Override
    public ApiResponse deleteInformacionClinica(UUID informacionClinicaId) {
        informacionClinicaRepository.deleteById(informacionClinicaId);
        return new ApiResponse(true, "Informacion clinica eliminado correctamente");
    }

    @Override
    public ApiResponse updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO) {
        InformacionClinica informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow(() -> new ResourceNotFoundException("InformacionClinica no encontrada con ID: " + informacionClinicaId));
        Optional.ofNullable(actualizarInformacionClinicaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(informacionClinica::setNombre);
        Optional.ofNullable(actualizarInformacionClinicaDTO.getEstado()).ifPresent(informacionClinica::setEstado);
        informacionClinicaRepository.save(informacionClinica);
        return new ApiResponse(true, "Informacion clinica actualizado correctamente");
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinica informacionClinica) {
        return modelMapper.map(informacionClinica, InformacionClinicaDTO.class);
    }

}

 */