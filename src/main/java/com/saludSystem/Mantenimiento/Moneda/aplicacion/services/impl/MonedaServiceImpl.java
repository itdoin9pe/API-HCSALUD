package com.saludSystem.Mantenimiento.Moneda.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.ActualizarMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.CrearMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.MonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.services.MonedaService;
import com.saludSystem.Mantenimiento.Moneda.dominio.MonedaModel;
import com.saludSystem.Mantenimiento.Moneda.infraestructura.repository.MonedaRepository;
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
public class MonedaServiceImpl implements MonedaService {

    private final MonedaRepository monedaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MonedaServiceImpl(MonedaRepository monedaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.monedaRepository = monedaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveMoneda(CrearMonedaDTO crearMonedaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MonedaModel monedaModel = new MonedaModel();
        monedaModel.setDescripcion(crearMonedaDTO.getDescripcion());
        monedaModel.setEstado(crearMonedaDTO.getEstado());
        monedaModel.setUser(user);
        monedaModel.setHospital(hospital);
        monedaRepository.save(monedaModel);
        return new ApiResponse(true, "Moneda registrada correctamente");
    }

    @Override
    public ListResponse<MonedaDTO> getAllMoneda(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MonedaModel> monedaModelPage = monedaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MonedaDTO> data = monedaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, monedaModelPage.getTotalElements(), monedaModelPage.getTotalPages(), monedaModelPage.getNumber() + 1);
    }

    @Override
    public List<MonedaDTO> getMonedaList() {
        return monedaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MonedaDTO getMonedaById(UUID monedaId) {
        MonedaModel monedaModel = monedaRepository.findById(monedaId).orElseThrow(() -> new ResourceNotFoundException("Moneda no encontrada"));
        return convertToDTO(monedaModel);
    }

    @Override
    public ApiResponse updateMoneda(UUID monedaId, ActualizarMonedaDTO actualizarMonedaDTO) {
        MonedaModel monedaModel = monedaRepository.findById(monedaId).orElseThrow(
                () -> new ResourceNotFoundException("Moneda no encontrada"));
        Optional.ofNullable(actualizarMonedaDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(monedaModel::setDescripcion);
        Optional.ofNullable(actualizarMonedaDTO.getEstado()).ifPresent(monedaModel::setEstado);
        monedaRepository.save(monedaModel);
        return new ApiResponse(true, "Moneda actualizada correctamente");
    }

    @Override
    public ApiResponse deleteMoneda(UUID monedaId) {
        monedaRepository.deleteById(monedaId);
        return new ApiResponse(true, "Moneda eliminada correctamente");
    }

    private MonedaDTO convertToDTO(MonedaModel monedaModel) {
        return modelMapper.map(monedaModel, MonedaDTO.class);
    }

}