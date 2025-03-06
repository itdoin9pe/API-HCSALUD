package com.saludSystem.aplicacion.services.modules.Configuracion.Sede.impl;

import com.saludSystem.aplicacion.dtos.Configuracion.Sede.ActualizarSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.CrearSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.SedeDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.dominio.entities.Generals.Sucursal;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.dominio.entities.Configuracion.Sede;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.infraestructura.repositories.Generals.SucursalRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SedeRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SysSaludRepository;
import com.saludSystem.aplicacion.services.modules.Configuracion.Sede.SedeService;
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
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Sede> sedePage = sedeRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<SedeDTO> data = sedePage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, sedePage.getTotalElements(), sedePage.getTotalPages(), sedePage.getNumber() + 1);
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
    public List<SedeDTO> getSedeList() {
        return sedeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse updateSede(UUID sedeId, ActualizarSedeDTO actualizarSedeDTO) {
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