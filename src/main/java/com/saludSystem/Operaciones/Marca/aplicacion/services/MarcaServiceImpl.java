package com.saludSystem.Operaciones.Marca.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.ActualizarMarcaDTO;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.CrearMarcaDTO;
import com.saludSystem.Operaciones.Marca.aplicacion.dtos.MarcaDTO;
import com.saludSystem.Operaciones.Marca.dominio.MarcaModel;
import com.saludSystem.Operaciones.Marca.infraestructura.repository.MarcaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MarcaServiceImpl(MarcaRepository marcaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.marcaRepository = marcaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveMarca(CrearMarcaDTO crearMarcaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MarcaModel marcaModel = new MarcaModel();
        marcaModel.setNombre(crearMarcaDTO.getNombre());
        marcaModel.setEstado(crearMarcaDTO.getEstado());
        marcaModel.setHospital(hospital);
        marcaModel.setUser(user);
        marcaRepository.save(marcaModel);
        return new ApiResponse(true, "Marca registrada correctamente");
    }

    @Override
    public List<MarcaDTO> getMarcaList() {
        return marcaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<MarcaDTO> getAllMarca(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MarcaModel> marcaModelPage = marcaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MarcaDTO> data = marcaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, marcaModelPage.getTotalElements(), marcaModelPage.getTotalPages(), marcaModelPage.getNumber() + 1);
    }

    @Override
    public MarcaDTO getMarcaById(UUID marcaId) {
        MarcaModel marcaModel = marcaRepository.findById(marcaId).orElseThrow( () -> new ResourceNotFoundException("Marca no encontrada"));
        return convertToDTO(marcaModel);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateMarca(UUID marcaId, ActualizarMarcaDTO actualizarMarcaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        MarcaModel marcaModel = marcaRepository.findById(marcaId).orElseThrow( () -> new ResourceNotFoundException("Marca no encontrada"));
        Optional.ofNullable(actualizarMarcaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(marcaModel::setNombre);
        Optional.ofNullable(actualizarMarcaDTO.getEstado()).ifPresent(marcaModel::setEstado);
        marcaRepository.save(marcaModel);
        return new ApiResponse(true, "Marca actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteMarca(UUID marcaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        marcaRepository.deleteById(marcaId);
        return new ApiResponse(true, "Marca eliminada correctamente");
    }

    private MarcaDTO convertToDTO(MarcaModel marcaModel) {
        return modelMapper.map(marcaModel, MarcaDTO.class);
    }

}