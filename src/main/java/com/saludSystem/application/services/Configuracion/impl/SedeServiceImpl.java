package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarSedeDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearSedeDTO;
import com.saludSystem.application.dtos.Configuracion.GET.SedeDTO;
import com.saludSystem.application.services.Configuracion.SedeService;
import com.saludSystem.domain.model.Configuracion.SedeEntity;
import com.saludSystem.domain.model.SucursalEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SedeRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
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
    private final SucursalRepository sucursalRepository;
    private final ModelMapper modelMapper;

    public SedeServiceImpl(SedeRepository sedeRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, SucursalRepository sucursalRepository, ModelMapper modelMapper) {
        this.sedeRepository = sedeRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public ApiResponse saveSede(CrearSedeDTO crearSedeDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        List<SucursalEntity> sucursales = sucursalRepository.findByHospital_HospitalId((user.getHospital().getHospitalId()));

        if (sucursales.isEmpty()) {
            throw new RuntimeException("No hay sucursales registradas para este hospital");
        }

        if (sucursales.size() > 1) {
            throw new RuntimeException("Existen múltiples sucursales, debe especificar una");
        }

        SucursalEntity sucursalEntity = sucursales.get(0); // Asigna la única sucursal existente
        SedeEntity sede = new SedeEntity();
        sede.setCodigo(crearSedeDTO.getCodigo());
        sede.setNombre(crearSedeDTO.getNombre());
        sede.setDireccion(crearSedeDTO.getDireccion());
        sede.setUbigeo(crearSedeDTO.getUbigeo());
        sede.setEstado(crearSedeDTO.getEstado());
        sede.setUser(user);
        sede.setHospital(hospital);
        sede.setSucursalEntity(sucursalEntity);
        sedeRepository.save(sede);
        return new ApiResponse(true, "Sede registrada correctamente");
    }

    @Override
    public ListResponse<SedeDTO> getAllEmpresa(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<SedeEntity> sedePage = sedeRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<SedeDTO> data = sedePage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, sedePage.getTotalElements(), sedePage.getTotalPages(), sedePage.getNumber() + 1);
    }

    @Override
    public SedeDTO getSedeById(UUID sedeId)
    {
        SedeEntity sede = sedeRepository.findById(sedeId)
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
    public List<SedeDTO> getSedeList() {
        return sedeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse updateSede(UUID sedeId, ActualizarSedeDTO actualizarSedeDTO) {
        SedeEntity sede = sedeRepository.findById(sedeId)
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

    private SedeDTO convertToDTO(SedeEntity sede) {
        return modelMapper.map(sede, SedeDTO.class);
    }

}