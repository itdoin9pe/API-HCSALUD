package com.saludSystem.Operaciones.Unidad.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.ActualizarUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.CrearUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.UnidadDTO;
import com.saludSystem.Operaciones.Unidad.dominio.UnidadModel;
import com.saludSystem.Operaciones.Unidad.infraestructura.repository.UnidadRepository;
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
public class UnidadServiceImpl implements UnidadService {

    private final UnidadRepository unidadRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UnidadServiceImpl(UnidadRepository unidadRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.unidadRepository = unidadRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveUnidad(CrearUnidadDTO crearUnidadDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        UnidadModel unidadModel = new UnidadModel();
        unidadModel.setNombre(crearUnidadDTO.getNombre());
        unidadModel.setSiglas(crearUnidadDTO.getSiglas());
        unidadModel.setDescripcion(crearUnidadDTO.getDescripcion());
        unidadModel.setEstado(crearUnidadDTO.getEstado());
        unidadModel.setUser(user);
        unidadModel.setHospital(hospital);
        unidadRepository.save(unidadModel);
        return new ApiResponse(true, "Unidad creada correctamente");
    }

    @Override
    public List<UnidadDTO> getUnidadList() {
        return unidadRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UnidadDTO getUnidadById(UUID unidadId) {
        UnidadModel unidadModel = unidadRepository.findById(unidadId).orElseThrow( () -> new ResourceNotFoundException("Unidad no encontrada"));
        return convertToDTO(unidadModel);
    }

    @Override
    public ListResponse<UnidadDTO> getAllUnidad(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<UnidadModel> unidadModelPage = unidadRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<UnidadDTO> data = unidadModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, unidadModelPage.getTotalElements(), unidadModelPage.getTotalPages(), unidadModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse updateUnidad(UUID unidadId, ActualizarUnidadDTO actualizarUnidadDTO) {
        UnidadModel unidadModel = unidadRepository.findById(unidadId).orElseThrow( () -> new ResourceNotFoundException("Unidad no encontrada"));
        Optional.ofNullable(actualizarUnidadDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(unidadModel::setNombre);
        Optional.ofNullable(actualizarUnidadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(unidadModel::setDescripcion);
        Optional.ofNullable(actualizarUnidadDTO.getSiglas()).filter(desc -> !desc.isBlank()).ifPresent(unidadModel::setSiglas);
        Optional.ofNullable(actualizarUnidadDTO.getEstado()).ifPresent(unidadModel::setEstado);
        unidadRepository.save(unidadModel);
        return new ApiResponse(true, "Unidad actualizada correctamente");
    }

    @Override
    public ApiResponse deleteUnidad(UUID unidadId) {
        unidadRepository.deleteById(unidadId);
        return new ApiResponse(true, "Unidad eliminado correctamente");
    }

    private UnidadDTO convertToDTO(UnidadModel unidadModel) {
        return modelMapper.map(unidadModel, UnidadDTO.class);
    }

}