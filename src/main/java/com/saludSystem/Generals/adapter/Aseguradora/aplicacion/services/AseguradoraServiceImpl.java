package com.saludSystem.Generals.adapter.Aseguradora.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.ActualizarAseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.AseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.CrearAseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.dominio.AseguradoraModel;
import com.saludSystem.Generals.adapter.Aseguradora.infraestructura.repositories.AseguradoraRepository;
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
public class AseguradoraServiceImpl implements AseguradoraService {
    
    private final AseguradoraRepository aseguradoraRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public AseguradoraServiceImpl(AseguradoraRepository aseguradoraRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.aseguradoraRepository = aseguradoraRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        AseguradoraModel aseguradora = new AseguradoraModel();
        aseguradora.setDescripcion(crearAseguradoraDTO.getDescripcion());
        aseguradora.setEstado(crearAseguradoraDTO.getEstado());
        aseguradora.setUser(user);
        aseguradora.setHospital(hospital);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora creada Correctamente");
    }

    @Override
    public List<AseguradoraDTO> getAseguradoraList() {
        return aseguradoraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AseguradoraDTO getAseguradoraById(UUID aseguradoraId) {
        AseguradoraModel aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada"));
        return convertToDTO(aseguradora);
    }

    @Override
    public ApiResponse updateAseguradora(UUID aseguradoraId, ActualizarAseguradoraDTO actualizarAseguradoraDTO) {
        AseguradoraModel aseguradora = aseguradoraRepository.findById(aseguradoraId).orElseThrow(
                () -> new ResourceNotFoundException("Aseguradora no encontrada"));
        Optional.ofNullable(actualizarAseguradoraDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(aseguradora::setDescripcion);
        Optional.ofNullable(actualizarAseguradoraDTO.getEstado()).ifPresent(aseguradora::setEstado);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora actualizada correctamente");
    }

    @Override
    public ApiResponse deleteAseguradora(UUID aseguradoraId) {
        aseguradoraRepository.deleteById(aseguradoraId);
        return new ApiResponse(true, "Aseguradora eliminada correctamente");
    }

    @Override
    public ListResponse<AseguradoraDTO> getAllAseguradoras(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AseguradoraModel> aseguradoraModelPage = aseguradoraRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AseguradoraDTO> data = aseguradoraModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, aseguradoraModelPage.getTotalElements(), aseguradoraModelPage.getTotalPages(), aseguradoraModelPage.getNumber() + 1);
    }

    private AseguradoraDTO convertToDTO(AseguradoraModel aseguradora) {
        return modelMapper.map(aseguradora, AseguradoraDTO.class);
    }

}