package com.saludSystem.aplicacion.services.modules.Catalogo.Medida.impl;

import com.saludSystem.aplicacion.dtos.Catalogo.Medida.ActualizarMedidaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Medida.CrearMedidaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Medida.MedidaDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.aplicacion.services.modules.Catalogo.Medida.MedidaService;
import com.saludSystem.dominio.entities.Catalogo.Medida;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.infraestructura.repositories.modules.Catalogo.MedidaRepository;
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
public class MedidaServiceImpl implements MedidaService {

    private final MedidaRepository medidaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MedidaServiceImpl(MedidaRepository medidaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.medidaRepository = medidaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveMedida(CrearMedidaDTO crearMedidaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Medida medida = new Medida();
        medida.setNombre(crearMedidaDTO.getNombre());
        medida.setEstado(crearMedidaDTO.getEstado());
        medida.setUser(user);
        medida.setHospital(hospital);
        medidaRepository.save(medida);
        return new ApiResponse(true, "Medida registrada correctamente");
    }

    @Override
    public List<MedidaDTO> getMedidaList() {
        return medidaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MedidaDTO getMedidaById(UUID medidaId) {
        Medida medida = medidaRepository.findById(medidaId).orElseThrow( () -> new ResourceNotFoundException("Medida no encontrada"));
        MedidaDTO dto = new MedidaDTO();
        dto.setMedidaId(medida.getMedidaId());
        dto.setNombre(medida.getNombre());
        dto.setEstado(medida.getEstado());
        return dto;
    }

    @Override
    public ApiResponse updateMedida(UUID medidaId, ActualizarMedidaDTO actualizarMedidaDTO) {
        Medida medida = medidaRepository.findById(medidaId).orElseThrow(
                () -> new ResourceNotFoundException("Medida no encontrada con ID" + medidaId));
        Optional.ofNullable(actualizarMedidaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(medida::setNombre);
        Optional.ofNullable(actualizarMedidaDTO.getEstado()).ifPresent(medida::setEstado);
        medidaRepository.save(medida);
        return new ApiResponse(true, "Medida actualizada con exito");
    }

    @Override
    public ApiResponse deleteMedida(UUID medidaId) {
        medidaRepository.deleteById(medidaId);
        return new ApiResponse(true, "Medida eliminada correctamente");
    }

    @Override
    public ListResponse<MedidaDTO> getAllMedida(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Medida> medidasPage = medidaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MedidaDTO> data = medidasPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, medidasPage.getTotalElements(), medidasPage.getTotalPages(), medidasPage.getNumber() + 1);
    }

    private MedidaDTO convertToDTO(Medida medida) {
        return modelMapper.map(medida, MedidaDTO.class);
    }

}