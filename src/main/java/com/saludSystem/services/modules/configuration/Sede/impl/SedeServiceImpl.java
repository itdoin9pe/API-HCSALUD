package com.saludSystem.services.modules.configuration.Sede.impl;

import com.saludSystem.dtos.configuration.Sede.ActualizarSedeDTO;
import com.saludSystem.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.services.modules.configuration.Sede.SedeService;
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
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SedeServiceImpl(SedeRepository sedeRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.sedeRepository = sedeRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveSede(CrearSedeDTO crearSedeDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Sede sede = new Sede();
        sede.setCodigo(crearSedeDTO.getCodigo());
        sede.setNombre(crearSedeDTO.getNombre());
        sede.setDireccion(crearSedeDTO.getDireccion());
        sede.setUbigeo(crearSedeDTO.getUbigeo());
        sede.setEstado(crearSedeDTO.getEstado());
        sede.setUser(user);
        sede.setHospital(hospital);
        sedeRepository.save(sede);
        return new ApiResponse(true, "Sede registrada correctamente");
    }

    @Override
    public ApiResponse updateSede(UUID sedeId, ActualizarSedeDTO actualizarSedeDTO)
    {
        Sede sede = sedeRepository.findById(sedeId)
                .orElseThrow( () -> new RuntimeException("Sede no encontrada" + sedeId));
        Optional.ofNullable(actualizarSedeDTO.getCodigo()).filter(desc -> !desc.isBlank()).ifPresent(sede::setCodigo);
        Optional.ofNullable(actualizarSedeDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(sede::setNombre);
        Optional.ofNullable(actualizarSedeDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(sede::setDireccion);
        Optional.ofNullable(actualizarSedeDTO.getUbigeo()).filter(desc -> !desc.isBlank()).ifPresent(sede::setUbigeo);
        Optional.ofNullable(actualizarSedeDTO.getEstado()).ifPresent(sede::setEstado);
        sedeRepository.save(sede);
        return new ApiResponse(true, "Sede actualizada correctamente");
    }

    @Override
    public ApiResponse deleteSede(UUID sedeId) {
        sedeRepository.deleteById(sedeId);
        return new ApiResponse(true, "Sede eliminada correctamente");
    }

    @Override
    public SedeDTO getSedeById(UUID sedeId)
    {
        Sede sede = sedeRepository.findById(sedeId)
                .orElseThrow( () -> new RuntimeException("Sede no encontrada"));
        SedeDTO dto = new SedeDTO();
        dto.setSedeId(sede.getSedeId());
        dto.setCodigo(sede.getCodigo());
        dto.setNombre(sede.getNombre());
        dto.setDireccion(sede.getDireccion());
        dto.setUbigeo(sede.getUbigeo());
        dto.setEstado(sede.getEstado());
        return dto;
    }

    @Override
    public List<SedeDTO> getSedeList()
    {
        return sedeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListResponse<SedeDTO> getAllEmpresa(UUID hospitalId, int page, int rows) {
        List<Sede> sedes = sedeRepository.findByHospital_HospitalId(hospitalId);
        List<SedeDTO> data = sedes.stream().map(sede -> {
            SedeDTO dto = new SedeDTO();
            dto.setSedeId(sede.getSedeId());
            dto.setCodigo(sede.getCodigo());
            dto.setNombre(sede.getNombre());
            dto.setDireccion(sede.getDireccion());
            dto.setUbigeo(sede.getUbigeo());
            dto.setEstado(sede.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    private SedeDTO convertToDTO(Sede sede) {
        return modelMapper.map(sede, SedeDTO.class);
    }

}