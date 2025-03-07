package com.saludSystem.aplicacion.services.modules.Catalogo.Alergia.impl;

import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.ActualizarAlergiaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.AlergiaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Alergias.CrearAlergiaDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.aplicacion.services.modules.Catalogo.Alergia.AlergiaService;
import com.saludSystem.dominio.entities.Catalogo.Alergia;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.infraestructura.repositories.modules.Catalogo.AlergiaRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SysSaludRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.infraestructura.security.exception.ResourceNotFoundException;
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
public class AlergiaServiceImpl implements AlergiaService {

    private final AlergiaRepository alergiaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AlergiaServiceImpl(AlergiaRepository alergiaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.alergiaRepository = alergiaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApiResponse saveAlergia(CrearAlergiaDTO crearAlergiaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Alergia alergia = new Alergia();
        alergia.setNombre(crearAlergiaDTO.getNombre());
        alergia.setEstado(crearAlergiaDTO.getEstado());
        alergia.setUser(user);
        alergia.setHospital(hospital);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia registrada correctamente");
    }

    @Override
    public List<AlergiaDTO> getAlergiaList() {
        return alergiaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteAlergia(UUID alergiaId) {
        alergiaRepository.deleteById(alergiaId);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public ApiResponse updateAlergia(UUID alergiaId, ActualizarAlergiaDTO actualizarAlergiaDTO) {
        Alergia alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));
        Optional.ofNullable(actualizarAlergiaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(alergia::setNombre);
        Optional.ofNullable(actualizarAlergiaDTO.getEstado()).ifPresent(alergia::setEstado);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public AlergiaDTO getAlergiaById(UUID alergiaId) {
        Alergia alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));
        AlergiaDTO dto = new AlergiaDTO();
        dto.setAlergiaId(alergia.getAlergiaId());
        dto.setNombre(alergia.getNombre());
        dto.setEstado(alergia.getEstado());
        return dto;
    }

    @Override
    public ListResponse<AlergiaDTO> getAllAlergia(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Alergia> alergiaPage = alergiaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AlergiaDTO> data = alergiaPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, alergiaPage.getTotalElements(), alergiaPage.getTotalPages(), alergiaPage.getNumber() +1 );
    }

    private AlergiaDTO convertToDTO(Alergia alergia) {
        return modelMapper.map(alergia, AlergiaDTO.class);
    }

}