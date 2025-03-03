package com.saludSystem.application.services.modules.configuration.Sede.impl;

import com.saludSystem.application.dtos.configuration.Sede.ActualizarSedeDTO;
import com.saludSystem.application.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.application.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;
import com.saludSystem.domain.entities.Generals.Sucursal;
import com.saludSystem.domain.entities.configuracion.User;
import com.saludSystem.domain.entities.configuracion.Sede;
import com.saludSystem.domain.entities.configuracion.SysSalud;
import com.saludSystem.infrastructure.repositories.Generals.SucursalRepository;
import com.saludSystem.infrastructure.repositories.modules.Configuration.UserRepository;
import com.saludSystem.infrastructure.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.infrastructure.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.application.services.modules.configuration.Sede.SedeService;
import org.modelmapper.ModelMapper;
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
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        List<Sucursal> sucursales = sucursalRepository.findByHospital_HospitalId((user.getHospital().getHospitalId()));

        if (sucursales.isEmpty()) {
            throw new RuntimeException("No hay sucursales registradas para este hospital");
        }

        if (sucursales.size() > 1) {
            throw new RuntimeException("Existen múltiples sucursales, debe especificar una");
        }

        Sucursal sucursal = sucursales.get(0); // Asigna la única sucursal existente
        Sede sede = new Sede();
        sede.setCodigo(crearSedeDTO.getCodigo());
        sede.setNombre(crearSedeDTO.getNombre());
        sede.setDireccion(crearSedeDTO.getDireccion());
        sede.setUbigeo(crearSedeDTO.getUbigeo());
        sede.setEstado(crearSedeDTO.getEstado());
        sede.setUser(user);
        sede.setHospital(hospital);
        sede.setSucursal(sucursal);
        sedeRepository.save(sede);
        return new ApiResponse(true, "Sede registrada correctamente");
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

    private SedeDTO convertToDTO(Sede sede) {
        return modelMapper.map(sede, SedeDTO.class);
    }

}